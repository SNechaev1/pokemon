package men.snechaev.pokemon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import men.snechaev.pokemon.dummy.DummyContent;
import men.snechaev.pokemon.json.PokemonJson;

public class PokemonViewModel extends AndroidViewModel {

    private final MutableLiveData<DummyContent.DummyItem> selected = new MutableLiveData<>();
    private final MutableLiveData<PokemonJson> pokemonObservable = new MutableLiveData<>();

    public PokemonViewModel(@NonNull Application application) {
        super(application);
    }


    public void selectId(DummyContent.DummyItem item) {
        selected.setValue(item);
    }

    public LiveData<DummyContent.DummyItem> getSelectedId() {
        return selected;
    }

    public void setPokemonObservable(PokemonJson pokemonJson) {
        pokemonObservable.setValue(pokemonJson);
    }

    public LiveData<PokemonJson> getPokemonObservable() {
        return pokemonObservable;
    }


}


