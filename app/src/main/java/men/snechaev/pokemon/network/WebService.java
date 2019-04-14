package men.snechaev.pokemon.network;

import men.snechaev.pokemon.json.PokemonJson;
import men.snechaev.pokemon.json.PokemonListJson;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("pokemon/")
    Call<PokemonListJson> getPokemonList();

    @GET("pokemon/{id}")
    Call<PokemonJson> getPokemon(@Path("id") int id);


}
