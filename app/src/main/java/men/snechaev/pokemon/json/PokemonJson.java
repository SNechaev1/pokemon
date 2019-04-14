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


//    Abilities

    public class Ability {

        @SerializedName("ability")
        @Expose
        public NestedAbility ability;
        @SerializedName("is_hidden")
        @Expose
        public Boolean isHidden;
        @SerializedName("slot")
        @Expose
        public Integer slot;

        @Override
        public String toString() {
            return "Ability{" +
                    "ability=" + ability +
                    ", isHidden=" + isHidden +
                    ", slot=" + slot +
                    '}';
        }
    }

    public class NestedAbility {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("url")
        @Expose
        public String url;

        @Override
        public String toString() {
            return "NestedAbility{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }


//    Stats

    public class Stat {

        @SerializedName("base_stat")
        @Expose
        public Integer baseStat;
        @SerializedName("effort")
        @Expose
        public Integer effort;
        @SerializedName("stat")
        @Expose
        public NestedStat stat;

        @Override
        public String toString() {
            return "Stat{" +
                    "baseStat=" + baseStat +
                    ", effort=" + effort +
                    ", stat=" + stat +
                    '}';
        }
    }

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

//      Sprites

    class Sprites {
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

