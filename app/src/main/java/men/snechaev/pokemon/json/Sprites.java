package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("front_default")
    @Expose
    String imageUrl;

    @Override
    public String toString() {
        return "Sprites{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
