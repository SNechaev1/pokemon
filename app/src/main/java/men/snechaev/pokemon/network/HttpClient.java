package men.snechaev.pokemon.network;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.inject.Inject;

import men.snechaev.pokemon.di.NetScope;
import men.snechaev.pokemon.json.ConverterJson;
import men.snechaev.pokemon.json.PokemonJson;
import men.snechaev.pokemon.ui.Pokemon;

@NetScope
public class HttpClient {

    private static WebService webService;
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private final MutableLiveData<Pokemon> pokemonMutable =
            new MutableLiveData<>();

    private final MutableLiveData<List<Pokemon>> pokemonListMutable =
            new MutableLiveData<>();


    @Inject
    public HttpClient(WebService webService) {
        HttpClient.webService = webService;
    }


    public LiveData<Pokemon> requestPokemon(int id) {

        CompletableFuture<PokemonJson> webCall = webService.getPokemon(id);
        try {
            Pokemon pokemon = ConverterJson.toPokemon(webCall.get());
            pokemonMutable.setValue(pokemon);
            Log.i("Web", "onResponse " + pokemon);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return pokemonMutable;
    }


    public LiveData<List<Pokemon>> requestPokemonList(int size) {
        pokemonListMutable
                .setValue(ConverterJson.toPokemonList(requestPokemonJsonList(size)));
        return pokemonListMutable;
    }


    private List<PokemonJson> requestPokemonJsonList(Integer size){

        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            ids.add(i);
        }

        List<CompletableFuture<PokemonJson>> futures =
                ids.stream()
                        .map(id -> webService.getPokemon(id))
                        .collect(Collectors.toList());

        List<PokemonJson> result =
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList());
        return result;
    }

}
