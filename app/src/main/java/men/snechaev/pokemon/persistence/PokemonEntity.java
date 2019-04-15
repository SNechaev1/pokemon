package men.snechaev.pokemon.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "pokemons")
public class PokemonEntity {

    @PrimaryKey()
    int pokemonId;

    String name;
    String url;
    String SpriteUrl;
    String SpriteLocalPath;

}
