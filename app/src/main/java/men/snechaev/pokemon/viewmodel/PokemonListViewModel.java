package men.snechaev.pokemon.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import men.snechaev.pokemon.BasicApp;
import men.snechaev.pokemon.persistence.PokemonEntity;

public class PokemonListViewModel extends AndroidViewModel {

    private final DataRepository repository;

    // MediatorLiveData can observe other LiveData objects and react on their emissions.
    private final MediatorLiveData<List<PokemonEntity>> observablePokemonList;



    public PokemonListViewModel(@NonNull Application application) {
        super(application);

        observablePokemonList = new MediatorLiveData<>();
        repository = ((BasicApp) application).getRepository();
        LiveData<List<PokemonEntity>> records = repository.getPokemonListDb();

        // observe the changes of the products from the database and forward them
        observablePokemonList.addSource(records, observablePokemonList::setValue);
    }

    public LiveData<List<PokemonEntity>> getPokemonList() {
        return observablePokemonList;
    }

    public LiveData<PokemonEntity> getPokemon(int id) {
        return repository.getPokemonDb(id);
    }




}
