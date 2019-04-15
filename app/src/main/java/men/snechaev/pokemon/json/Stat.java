package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat {

    @SerializedName("base_stat")
    @Expose
    Integer baseStat;
    @SerializedName("effort")
    @Expose
    Integer effort;
    @SerializedName("stat")
    @Expose
    NestedStat stat;

    @Override
    public String toString() {
        return "Stat{" +
                "baseStat=" + baseStat +
                ", effort=" + effort +
                ", stat=" + stat +
                '}';
    }
}
