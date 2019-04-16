package men.snechaev.pokemon.viewmodel;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import men.snechaev.pokemon.network.HttpClient;
import men.snechaev.pokemon.persistence.ConverterEntity;
import men.snechaev.pokemon.persistence.PokemonDatabase;
import men.snechaev.pokemon.persistence.PokemonEntity;
import men.snechaev.pokemon.ui.Pokemon;


public class DataRepository {

    private static DataRepository instance;
    private final PokemonDatabase db;
    private MediatorLiveData<List<PokemonEntity>> observablePokemonListDb;
    private MediatorLiveData<PokemonEntity> observablePokemonDb;
    private MediatorLiveData<Pokemon> observablePokemonNet;


    private DataRepository(final PokemonDatabase db) {

//        Database Observers
        this.db = db;
//        observablePokemonListDb = new MediatorLiveData<>();
//        observablePokemonListDb.addSource(this.db.pokemonDao().getAll(),
//                pokemonEntities -> {
//                    if (this.db.isDatabaseCreated().getValue() != null) {
//                        observablePokemonListDb.postValue(pokemonEntities);
//                    }
//                });

//        Network Observers

//        observablePokemonNet = new MediatorLiveData<>();
//        observablePokemonNet.addSource(requestPokemonNet(1),
//                data -> );



    }

    public static DataRepository getInstance(final PokemonDatabase database) {
        if (instance == null) {
            synchronized (DataRepository.class) {
                if (instance == null) {
                    instance = new DataRepository(database);
                }
            }
        }
        return instance;
    }

//    Get Data from Database
    public LiveData<List<Pokemon>> getPokemonListDb() {

        return Transformations
                .map(db.pokemonDao().getAll(), ConverterEntity::toPokemonList);
    }

    public LiveData<Pokemon> getPokemonDb(Integer id) {
        return Transformations
                .map(db.pokemonDao().get(id), ConverterEntity::toPokemon);
    }

    public void savePokemon(PokemonEntity pokemonEntity) {
        db.pokemonDao().insert(pokemonEntity);
    }

//    Get Data from Network

    private MutableLiveData<List<Pokemon>> mutablePokemonListNet;

//    LiveData<Pokemon> pokemonLiveData = Transformations.switchMap(repoIdLiveData, repoId -> {
//                if (repoId.isEmpty()) {
//                    return AbsentLiveData.create();
//                }
//                return repository.loadRepo(repoId);
//            }
//    );

//    public static LiveData<Y> switchMap (LiveData<X> source,
//                                         Function<X, LiveData<Y>> switchMapFunction)

//    public LiveData<List<Pokemon>> getUsersWithNameLiveData() {
//        return Transformations.switchMap(
//                mutablePokemonListNet,
//                list -> requestPokemonListNet());
//    }


    public List<Pokemon> requestPokemonListNet() {
        return HttpClient.getInstance().requestPokemonList(20);
    }

    public Pokemon requestPokemonNet(int id) {
        return HttpClient.getInstance().requestPokemon(id);
    }





}
