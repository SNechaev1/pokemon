package men.snechaev.pokemon.persistence;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "pokemon_abilities_join",
primaryKeys = { "pokemonId", "abilityId" },
        foreignKeys = {
@ForeignKey(entity = PokemonEntity.class,
        parentColumns = "pokemonId",
        childColumns = "joinPokemonId"),
@ForeignKey(entity = PokemonAbilitiesEntity.class,
        parentColumns = "abilityId",
        childColumns = "joinAbilityId")
                })
public class PokemonAbilitiesJoin {

    int joinPokemonId;
    int joinAbilityId;

}
