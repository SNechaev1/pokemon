package men.snechaev.pokemon.network;

import java.util.concurrent.CompletableFuture;

import men.snechaev.pokemon.json.PokemonJson;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("pokemon/{id}")
    CompletableFuture<PokemonJson> getPokemon(@Path("id") int id);

}
