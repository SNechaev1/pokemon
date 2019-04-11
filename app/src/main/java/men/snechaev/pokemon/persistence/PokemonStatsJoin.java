package men.snechaev.pokemon.persistence;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "pokemon_stats_join",
        primaryKeys = { "pokemonId", "statsId" },
        foreignKeys = {
                @ForeignKey(entity = PokemonEntity.class,
                        parentColumns = "pokemonId",
                        childColumns = "joinPokemonId"),
                @ForeignKey(entity = PokemonStatsEntity.class,
                        parentColumns = "statsId",
                        childColumns = "joinStatsId")
        })
public class PokemonStatsJoin {

    int joinPokemonId;
    int joinStatsId;

}