package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PokemonListJson {

        @SerializedName("count")
        @Expose
        public Integer count;
        @SerializedName("next")
        @Expose
        public String next;
        @SerializedName("previous")
        @Expose
        public Object previous;
        @SerializedName("results")
        @Expose
        public ArrayList<PokemonBasic> results;


        public class PokemonBasic {

            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("url")
            @Expose
            public String url;

            @Override
            public String toString() {
                return "PokemonBasic{" +
                        "name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

    @Override
    public String toString() {
        return "PokemonListJson{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous=" + previous +
                ", results=" + results +
                '}';
    }
}

