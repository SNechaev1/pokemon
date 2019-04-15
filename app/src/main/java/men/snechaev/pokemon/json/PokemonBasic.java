package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonBasic {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("url")
    @Expose
    String url;

    @Override
    public String toString() {
        return "PokemonBasic{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
