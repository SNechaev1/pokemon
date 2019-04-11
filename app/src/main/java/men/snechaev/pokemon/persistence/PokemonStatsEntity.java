package men.snechaev.pokemon.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stats")
public class PokemonStatsEntity {

    @PrimaryKey
    int statsId;
    int baseStat;
    int effort;

    String name;
    String url;

}
