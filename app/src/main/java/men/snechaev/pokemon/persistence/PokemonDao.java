package men.snechaev.pokemon.persistence;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PokemonEntity pokemonEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PokemonEntity> pokemonEntities);

    @Query("SELECT * FROM pokemons" +
            " INNER JOIN pokemon_stats_join" +
            " ON pokemons.pokemonId = pokemon_stats_join.joinPokemonId" +
            " INNER JOIN pokemon_abilities_join" +
            " ON pokemons.pokemonId = pokemon_abilities_join.joinPokemonId" +
            " WHERE pokemons.pokemonId = :pokemonId")
    LiveData<PokemonEntity> get(int pokemonId);

    @Query("SELECT * FROM pokemons")
    LiveData<List<PokemonEntity>> getAll();

    @Query("DELETE FROM pokemons WHERE pokemonId = :pokemonId")
    void deleteById(int pokemonId);

    @Delete
    public void delete(PokemonEntity pokemonEntity);

    @Delete
    public void deleteAll(List<PokemonEntity> pokemonEntityList);
}
