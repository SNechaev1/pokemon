package men.snechaev.pokemon.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import men.snechaev.pokemon.ui.Pokemon;

public class PokemonViewModel extends AndroidViewModel {

    private final MutableLiveData<Pokemon> selected = new MutableLiveData<>();
    private final MutableLiveData<Pokemon> pokemonObservable = new MutableLiveData<>();

    public PokemonViewModel(@NonNull Application application) {
        super(application);
    }


    public void selectId(Pokemon pokemon) {
        selected.setValue(pokemon);
    }

    public LiveData<Pokemon> getSelectedId() {
        return selected;
    }

    public void setPokemonObservable(Pokemon pokemon) {
        pokemonObservable.setValue(pokemon);
    }

    public LiveData<Pokemon> getPokemonObservable() {
        return pokemonObservable;
    }


}


