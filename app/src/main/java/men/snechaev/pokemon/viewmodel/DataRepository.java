package men.snechaev.pokemon.viewmodel;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import men.snechaev.pokemon.json.PokemonJson;
import men.snechaev.pokemon.network.HttpClient;
import men.snechaev.pokemon.persistence.PokemonDatabase;
import men.snechaev.pokemon.persistence.PokemonEntity;


public class DataRepository {

    private static DataRepository instance;
    private final PokemonDatabase db;
    private MediatorLiveData<List<PokemonEntity>> observablePokemonListDb;
    private MediatorLiveData<PokemonEntity> observablePokemonDb;
    private MediatorLiveData<List<PokemonJson>> observablePokemonListNet;
    private MediatorLiveData<PokemonJson> observablePokemonNet;


    private DataRepository(final PokemonDatabase db) {

//        Database Observers
        this.db = db;
        observablePokemonListDb = new MediatorLiveData<>();
        observablePokemonListDb.addSource(this.db.pokemonDao().getAll(),
                pokemonEntities -> {
                    if (this.db.isDatabaseCreated().getValue() != null) {
                        observablePokemonListDb.postValue(pokemonEntities);
                    }
                });

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
    public LiveData<List<PokemonEntity>> getPokemonListDb() {
        return observablePokemonListDb;
    }

    public LiveData<PokemonEntity> getPokemonDb(Integer pokemonId) {
        return db.pokemonDao().get(pokemonId);
    }

    public void savePokemon(PokemonEntity pokemonEntity) {
        db.pokemonDao().insert(pokemonEntity);
    }

//    Get Data from Network

    public void requestPokemonListNet() {
        HttpClient.getInstance().requestPokemonList();
    }

    public LiveData<PokemonJson> requestPokemonNet(int id) {
        return HttpClient.getInstance().requestPokemon(id);
    }




}
