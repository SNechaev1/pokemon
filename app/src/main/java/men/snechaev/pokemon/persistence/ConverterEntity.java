package men.snechaev.pokemon.persistence;

import java.util.ArrayList;
import java.util.List;

import men.snechaev.pokemon.ui.Pokemon;

public class ConverterEntity {

    public static Pokemon toPokemon(PokemonEntity pokemonEntity) {

        Pokemon pokemon = new Pokemon();
        String id = String.valueOf(pokemonEntity.id);

        pokemon.setId(id);
        pokemon.setName(pokemonEntity.name);
        pokemon.setSpriteUrl(pokemonEntity.SpriteUrl);

//        ArrayList<String> abilities = new ArrayList<>();
//        for (Ability ability: pokemonJson.abilities) {
//            abilities.add(ability.ability.name);
//        }
//        pokemon.setAbilities(abilities);
//
//        HashMap<String, Integer> stats = new HashMap<>();
//        for (Stat stat: pokemonJson.stats) {
//            Integer baseStat = stat.baseStat;
//            String name = stat.stat.name;
//            stats.put(name, baseStat);
//        }
//        pokemon.setStats(stats);

        return pokemon;
    }

    public static List<Pokemon> toPokemonList(List<PokemonEntity> pokemonEntityList) {

        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        for (PokemonEntity pokemonEntity: pokemonEntityList) {
            pokemonList.add(toPokemon(pokemonEntity));
        }

        return pokemonList;
    }

    public static PokemonEntity toPokemonEntity(Pokemon pokemon) {

        PokemonEntity pokemonEntity = new PokemonEntity();

        pokemonEntity.id = pokemon.getId();
        pokemonEntity.name = pokemon.getName();
        pokemonEntity.SpriteUrl = pokemon.getSpriteUrl();

//        ArrayList<String> abilities = new ArrayList<>();
//        for (Ability ability: pokemonJson.abilities) {
//            abilities.add(ability.ability.name);
//        }
//        pokemon.setAbilities(abilities);
//
//        HashMap<String, Integer> stats = new HashMap<>();
//        for (Stat stat: pokemonJson.stats) {
//            Integer baseStat = stat.baseStat;
//            String name = stat.stat.name;
//            stats.put(name, baseStat);
//        }
//        pokemon.setStats(stats);

        return pokemonEntity;
    }

    public static List<PokemonEntity> toPokemonEntityList(List<Pokemon> pokemonList) {

        ArrayList<PokemonEntity> pokemonEntityList = new ArrayList<>();

        for (Pokemon pokemon: pokemonList) {
            pokemonEntityList.add(toPokemonEntity(pokemon));
        }

        return pokemonEntityList;
    }

}
