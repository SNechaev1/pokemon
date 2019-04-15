package men.snechaev.pokemon.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
