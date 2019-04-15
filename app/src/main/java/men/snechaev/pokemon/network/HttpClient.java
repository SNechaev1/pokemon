package men.snechaev.pokemon.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import men.snechaev.pokemon.BuildConfig;
import men.snechaev.pokemon.json.ConverterJson;
import men.snechaev.pokemon.json.PokemonBasic;
import men.snechaev.pokemon.json.PokemonJson;
import men.snechaev.pokemon.json.PokemonListJson;
import men.snechaev.pokemon.ui.Pokemon;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static HttpClient instance;
    private static WebService client;
//    public WebService client;
    List<PokemonBasic> pokemonBasicList;
    private final MutableLiveData<Pokemon> pokemonMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Pokemon>> pokemonListMutableLiveData = new MutableLiveData<>();

//    static PokemonViewModel pokemonViewModel;

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";
    public static final int NETWORK_TIMEOUT = 3000;

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

        client = retrofit.create(WebService.class);
    }

    public void sendNetworkRequest() {

        requestPokemonList();
//        requestPokemon(2);

    }

    public MutableLiveData<Pokemon> requestPokemon(int id) {
        Call<PokemonJson>  webCall = client.getPokemon(id);
        webCall.enqueue(new Callback<PokemonJson>() {
            @Override
            public void onResponse(Call<PokemonJson> call, Response<PokemonJson> response) {

                if (response.isSuccessful()) {
                    PokemonJson pokemonJson = response.body();
                    Log.i("Web", "onResponse:pokemonJson " + pokemonJson);
                    assert pokemonJson != null;
                    Pokemon pokemon = ConverterJson.toUI(pokemonJson);
                    Log.i("Web", "onResponse:pokemon " + pokemon);
                    pokemonMutableLiveData.setValue(pokemon);
                }
            }

            @Override
            public void onFailure(Call<PokemonJson> call, Throwable t) {
                pokemonMutableLiveData.setValue(null);
                t.printStackTrace();
            }
        });
        return pokemonMutableLiveData;
    }


    public void requestPokemonList() {
        Call<PokemonListJson> webCall = client.getPokemonList();
        webCall.enqueue(new Callback<PokemonListJson>() {
            @Override
            public void onResponse(Call<PokemonListJson> call, Response<PokemonListJson> response) {
                PokemonListJson pokemon = response.body();
                Log.i("Web", "onResponse: " + pokemon);
            }

            @Override
            public void onFailure(Call<PokemonListJson> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
