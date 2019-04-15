package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonJson {

    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("abilities")
    @Expose
    ArrayList<Ability> abilities;
    @SerializedName("stats")
    @Expose
    ArrayList<Stat> stats;
    @SerializedName("sprites")
    @Expose
    Sprites sprites;


    @Override
    public String toString() {
        return "PokemonJson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", abilities=" + abilities +
                ", stats=" + stats +
                ", sprites=" + sprites +
                '}';
    }
}

