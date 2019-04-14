package men.snechaev.pokemon.persistence;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import men.snechaev.pokemon.AppExecutors;

@androidx.room.Database(entities = {PokemonEntity.class,
        PokemonAbilitiesEntity.class,
        PokemonStatsEntity.class,
        PokemonAbilitiesJoin.class,
        PokemonStatsJoin.class},
        version = 1)
public abstract class PokemonDatabase extends RoomDatabase {

    @VisibleForTesting
    public static final String DATABASE_NAME = "pokemons";
    private static PokemonDatabase instance;

    public abstract PokemonDao pokemonDao();

    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();

    public static PokemonDatabase getInstance(final Context context, final AppExecutors executors) {
        if (instance == null) {
            synchronized (PokemonDatabase.class) {
                if (instance == null) {
                    instance = buildDatabase(context.getApplicationContext(), executors);
                    instance.checkDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return instance;
    }


    private static PokemonDatabase buildDatabase(final Context appContext,
                                                 final AppExecutors executors) {
        return Room.databaseBuilder(appContext, PokemonDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()   // temporary(recreate db on changes)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            PokemonDatabase database = PokemonDatabase.getInstance(appContext, executors);
                            database.notifyDatabaseCreated();
                        });
                    }
                })
                .build();
    }

    private void checkDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            notifyDatabaseCreated();
        }
    }

    private void notifyDatabaseCreated() {
        isDatabaseCreated.postValue(true);
    }

    private static void insertAll(final PokemonDatabase database, final List<PokemonEntity> pokemonEntities) {
        database.runInTransaction(() -> database.pokemonDao().insertAll(pokemonEntities));
    }

    private static void insert(final PokemonDatabase database, final PokemonEntity pokemonEntity) {
        database.runInTransaction(() -> database.pokemonDao().insert(pokemonEntity));
    }

    private void testData() {
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.pokemonId = 1;
        pokemonEntity.name = "testName";
        pokemonEntity.SpriteLocalPath = "LocalPath";
        pokemonEntity.SpriteUrl = "SpriteUrl";
        pokemonEntity.url = "url";
        PokemonStatsEntity pokemonStatsEntity = new PokemonStatsEntity();
        pokemonStatsEntity.name = "statName";
        pokemonStatsEntity.baseStat = 22;
        pokemonStatsEntity.effort = 33;
        pokemonStatsEntity.url = "statUrl";
        PokemonAbilitiesEntity pokemonAbilitiesEntity = new PokemonAbilitiesEntity();
        pokemonAbilitiesEntity.name = "AbilityName";
        pokemonAbilitiesEntity.url = "AbilityUrl";
    }


    public LiveData<Boolean> isDatabaseCreated() {
        return isDatabaseCreated;
    }

//    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("");
//        }
//    };
}

