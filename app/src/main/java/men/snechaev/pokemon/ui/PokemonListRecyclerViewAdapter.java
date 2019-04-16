package men.snechaev.pokemon.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import men.snechaev.pokemon.R;
import men.snechaev.pokemon.ui.PokemonListFragment.OnListFragmentInteractionListener;

/**
 * makes a call to the specified {@link OnListFragmentInteractionListener}.
 */
public class PokemonListRecyclerViewAdapter extends RecyclerView.Adapter<PokemonListRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> items;
    private final OnListFragmentInteractionListener listener;

    public PokemonListRecyclerViewAdapter(List<Pokemon> items, OnListFragmentInteractionListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_listofpokemons, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = items.get(position);
        holder.tvId.setText(items.get(position).getId());
        holder.tvName.setText(items.get(position).getName());

        holder.view.setOnClickListener(v -> {
            if (null != listener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                listener.onListFragmentInteraction(holder.item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View view;
        final TextView tvId;
        final TextView tvName;
        Pokemon item;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            tvId = view.findViewById(R.id.tv_pokemon_id);
            tvName = view.findViewById(R.id.tv_pokemon_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }
    }
}
