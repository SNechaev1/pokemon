package men.snechaev.pokemon.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import men.snechaev.pokemon.ui.Pokemon;

public class ConverterJson {

    final MutableLiveData<List<Pokemon>> observablePokemonList = new MutableLiveData<>();


    public static Pokemon toUI(PokemonJson pokemonJson) {

      Pokemon pokemon = new Pokemon();
      Integer id = Integer.decode(pokemonJson.id);

      pokemon.setPokemonId(id);
      pokemon.setName(pokemonJson.name);
      pokemon.setSpriteUrl(pokemonJson.sprites.imageUrl);

        ArrayList<String> abilities = new ArrayList<>();
        for (Ability ability: pokemonJson.abilities) {
            abilities.add(ability.ability.name);
        }
        pokemon.setAbilities(abilities);

        HashMap<String, Integer> stats = new HashMap<>();
        for (Stat stat: pokemonJson.stats) {
            Integer baseStat = stat.baseStat;
            String name = stat.stat.name;
            stats.put(name, baseStat);
        }
        pokemon.setStats(stats);

        return pokemon;
    }
}
