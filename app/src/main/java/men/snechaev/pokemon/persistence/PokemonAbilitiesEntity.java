package men.snechaev.pokemon.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "abilities")
public class PokemonAbilitiesEntity {

    @PrimaryKey
    int abilityId;

    String name;
    String url;

}
