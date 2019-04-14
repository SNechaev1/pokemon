package men.snechaev.pokemon.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import men.snechaev.pokemon.R;
import men.snechaev.pokemon.viewmodel.PokemonViewModel;


public class PokemonFragment extends Fragment {
    public static final String TAG = "PokemonFragment";
    PokemonViewModel pokemonViewModel;

//    private OnFragmentInteractionListener listener;

    public PokemonFragment() { }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            listener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pokemonViewModel = ViewModelProviders.of(getActivity()).get(PokemonViewModel.class);
//        final Observer<DummyContent.DummyItem> idObserver = dummyItem -> {
//            Log.i(TAG, "onCreate: " + dummyItem.id);
//        };
        pokemonViewModel.getSelectedId().observe(this, dummyItem ->  {
            Log.i(TAG, "onCreate: " + dummyItem.id);
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon, container, false);
    }



    @Override
    public void onResume() {
        super.onResume();
    }



    @Override
    public void onDetach() {
        super.onDetach();
//        listener = null;
    }

//communication to the activity and potentially other fragments contained in that activity.
//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }

}
