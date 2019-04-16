package men.snechaev.pokemon.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import men.snechaev.pokemon.BuildConfig;
import men.snechaev.pokemon.json.ConverterJson;
import men.snechaev.pokemon.json.PokemonJson;
import men.snechaev.pokemon.ui.Pokemon;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static HttpClient instance;
    private static WebService webService;
    private Pokemon pokemon = new Pokemon();
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    public static HttpClient getInstance() {
        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new HttpClient();
                    buildRetrofit();
                }
            }
        }
        return instance;
    }

    private static void buildRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);

        Retrofit retrofit = builder.build();

        webService = retrofit.create(WebService.class);
    }


    public Pokemon requestPokemon(int id) {

        CompletableFuture<PokemonJson> webCall = webService.getPokemon(id);
        try {
            pokemon = ConverterJson.toPokemon(webCall.get());
            Log.i("Web", "onResponse " + pokemon);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return pokemon;
    }


    public List<Pokemon> requestPokemonList(int size) {
        return ConverterJson.toPokemonList(requestPokemonJsonList(size));
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
