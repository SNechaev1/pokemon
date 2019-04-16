package men.snechaev.pokemon.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import men.snechaev.pokemon.AppExecutors;
import men.snechaev.pokemon.BasicApp;
import men.snechaev.pokemon.ui.Pokemon;

public class PokemonListViewModel extends ViewModel {

    private AppExecutors appExecutors;
    private BasicApp basicApp;
    private DataRepository repository;
    private MutableLiveData<Boolean> isModeDiscover;

    public PokemonListViewModel() {
        repository = basicApp.getRepository();
    }


    // MediatorLiveData can observe other LiveData objects and react on their emissions.
//    private final MediatorLiveData<List<Pokemon>> observablePokemonList;


//    public PokemonListViewModel(@NonNull Application application) {
//        super(application);

//        observablePokemonList = new MediatorLiveData<>();


//        LiveData<List<Pokemon>> records = repository.getPokemonListDb();

        // observe the changes of the products from the database and forward them
//        observablePokemonList.addSource(records, observablePokemonList::setValue);
//    }

    public void setModeDiscovery(Boolean isModeDiscovery) {
        this.isModeDiscover.setValue(isModeDiscovery);
    }

    public LiveData<Boolean> getModeDiscovery() {
        return this.isModeDiscover;
    }

//    public LiveData<List<Pokemon>> getPokemonListDb() {
//        return observablePokemonList;
//    }

    public LiveData<Pokemon> getPokemonDb(int id) {
        return repository.getPokemonDb(id);
    }

    public List<Pokemon> getPokemonListNet() {
        return repository.requestPokemonListNet();
    }

    public Pokemon getPokemonNet(int id) {
        return repository.requestPokemonNet(id);
    }




}
