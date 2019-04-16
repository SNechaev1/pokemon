package men.snechaev.pokemon.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import men.snechaev.pokemon.ui.Pokemon;

//  Converter from PokemonJson class, which has multiple nested classes inside,
//  to more pretty Pokemon class
public class ConverterJson {

    public static Pokemon toPokemon(PokemonJson pokemonJson) {

      Pokemon pokemon = new Pokemon();
      String id = pokemonJson.id;

      pokemon.setId(id);
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

    public static List<Pokemon> toPokemonList(List<PokemonJson> pokemonJsonList) {

        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        for (PokemonJson pokemonJson: pokemonJsonList) {
            pokemonList.add(toPokemon(pokemonJson));
        }

        return pokemonList;
    }

}
