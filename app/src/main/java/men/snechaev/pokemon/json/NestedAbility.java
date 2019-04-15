package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NestedAbility {

    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("url")
    @Expose
    String url;

    @Override
    public String toString() {
        return "NestedAbility{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
