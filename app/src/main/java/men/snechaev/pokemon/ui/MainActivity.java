package men.snechaev.pokemon.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import men.snechaev.pokemon.R;
import men.snechaev.pokemon.dummy.DummyContent;
import men.snechaev.pokemon.viewmodel.DataRepository;
import men.snechaev.pokemon.viewmodel.PokemonViewModel;

public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnListFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private PokemonViewModel pokemonViewModel;


    DataRepository dataRepository;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_discover:

                        return true;
                    case R.id.navigation_pokedex:

                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        applyFragment(new PokemonFragment(), R.id.fragment_container, PokemonFragment.TAG);
        applyFragment(new PokemonListFragment(), R.id.fragment_container, PokemonListFragment.TAG);

    }

    public void applyFragment(Fragment fragment, int containerViewId, String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(fragmentTag)
                .commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show();
//        pokemonViewModel.selectId(item);
        dataRepository.requestPokemonNet(Integer.getInteger(item.id));
        applyFragment(new PokemonFragment(), R.id.fragment_container, PokemonFragment.TAG);

    }

    public void savePokemon(View view) {

    }

    private boolean isNetworkConnected(){
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
