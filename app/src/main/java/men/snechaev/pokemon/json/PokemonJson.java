package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonJson {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("abilities")
    @Expose
    public ArrayList<Ability> abilities;
    @SerializedName("stats")
    @Expose
    public ArrayList<Stat> stats;
    @SerializedName("sprites")
    @Expose
    public Sprites sprites;


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

