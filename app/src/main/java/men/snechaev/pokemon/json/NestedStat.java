package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NestedStat {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("url")
    @Expose
    public String url;

    @Override
    public String toString() {
        return "NestedStat{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
