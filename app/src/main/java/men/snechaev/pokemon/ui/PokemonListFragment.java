package men.snechaev.pokemon.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import men.snechaev.pokemon.AppExecutors;
import men.snechaev.pokemon.BasicApp;
import men.snechaev.pokemon.R;
import men.snechaev.pokemon.viewmodel.PokemonListViewModel;
import men.snechaev.pokemon.viewmodel.PokemonViewModel;


public class PokemonListFragment extends Fragment {

    public static final String TAG = "PokemonListFragment";
    BasicApp basicApp = new BasicApp();
    private AppExecutors appExecutors;

    private PokemonListViewModel pokemonListViewModel;
    private PokemonViewModel pokemonViewModel;
    private OnListFragmentInteractionListener mListener;
    public PokemonListFragment() { }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemonListViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(PokemonListViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listofpokemons_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
//            basicApp.getRepository().requestPokemonListNet();
            recyclerView.setAdapter(
                    new PokemonListRecyclerViewAdapter(pokemonListViewModel.getPokemonListNet(), mListener));

//            recyclerView.setAdapter(
//                    new PokemonListRecyclerViewAdapter(HttpClient.getInstance().requestPokemonList(20), mListener));

//            recyclerView.setAdapter(
//                    new PokemonListRecyclerViewAdapter(DataRepository
//                            .getInstance(PokemonDatabase.getInstance(getContext(), appExecutors))
//                            .requestPokemonListNet(), mListener));



//            pokemonListViewModel.getModeDiscovery().observe(this, isModeDiscovery ->  {
//                Log.i(TAG, "mode Discovery: " + isModeDiscovery);
//                if (isModeDiscovery) {
//                    pokemonListViewModel.getPokemonListNet();
//                    recyclerView.setAdapter(
//                            new PokemonListRecyclerViewAdapter(pokemonListViewModel.getPokemonListNet(), mListener));
//                } else {
////                    recyclerView.setAdapter(
////                            new PokemonListRecyclerViewAdapter(pokemonListViewModel.getPokemonListDb(), mListener));
//                }
//            });
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Pokemon item);
    }
}
