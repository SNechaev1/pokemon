package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ability {

    @SerializedName("ability")
    @Expose
    NestedAbility ability;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("slot")
    @Expose
    private Integer slot;

    @Override
    public String toString() {
        return "Ability{" +
                "ability=" + ability +
                ", isHidden=" + isHidden +
                ", slot=" + slot +
                '}';
    }
}
