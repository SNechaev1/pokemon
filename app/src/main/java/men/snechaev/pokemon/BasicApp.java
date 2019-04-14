package men.snechaev.pokemon;

import android.app.Application;

import men.snechaev.pokemon.persistence.PokemonDatabase;
import men.snechaev.pokemon.viewmodel.DataRepository;

// Android Application class. Used for accessing singletons.
public class BasicApp extends Application {

    private AppExecutors appExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        appExecutors = new AppExecutors();
    }

    public PokemonDatabase getDatabase() {
        return PokemonDatabase.getInstance(this, appExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}
