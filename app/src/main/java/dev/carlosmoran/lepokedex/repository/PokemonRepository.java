package dev.carlosmoran.lepokedex.repository;

import java.util.ArrayList;
import java.util.List;

import dev.carlosmoran.lepokedex.model.Pokemon;
import dev.carlosmoran.lepokedex.model.TipoPokemon;

public class PokemonRepository {
    private static PokemonRepository instance;
    private final ArrayList<Pokemon> pokemons = new ArrayList<>();

    public PokemonRepository() {
        pokemons.add(new Pokemon("Pikachu", 200, 180, 150, 200, TipoPokemon.ELECTRICO));
        pokemons.add(new Pokemon("Raichu", 240, 220, 180, 230, TipoPokemon.ELECTRICO));
        pokemons.add(new Pokemon("Jolteon", 210, 190, 160, 260, TipoPokemon.ELECTRICO));
        pokemons.add(new Pokemon("Magnemite", 150, 130, 220, 90, TipoPokemon.ELECTRICO));
        pokemons.add(new Pokemon("Electabuzz", 230, 230, 170, 210, TipoPokemon.ELECTRICO));
        pokemons.add(new Pokemon("Zapdos", 290, 250, 220, 200, TipoPokemon.ELECTRICO));
        pokemons.add(new Pokemon("Charmander", 180, 160, 130, 170, TipoPokemon.FUEGO));
        pokemons.add(new Pokemon("Charizard", 280, 250, 200, 220, TipoPokemon.FUEGO));
        pokemons.add(new Pokemon("Vulpix", 170, 140, 140, 180, TipoPokemon.FUEGO));
        pokemons.add(new Pokemon("Arcanine", 300, 270, 210, 210, TipoPokemon.FUEGO));
        pokemons.add(new Pokemon("Magmar", 240, 240, 170, 190, TipoPokemon.FUEGO));
        pokemons.add(new Pokemon("Squirtle", 190, 150, 180, 140, TipoPokemon.AGUA));
        pokemons.add(new Pokemon("Blastoise", 290, 200, 260, 160, TipoPokemon.AGUA));
        pokemons.add(new Pokemon("Psyduck", 200, 160, 150, 150, TipoPokemon.AGUA));
        pokemons.add(new Pokemon("Gyarados", 310, 290, 210, 180, TipoPokemon.AGUA));
        pokemons.add(new Pokemon("Lapras", 350, 220, 220, 130, TipoPokemon.AGUA));
        pokemons.add(new Pokemon("Sandshrew", 190, 190, 230, 120, TipoPokemon.TIERRA));
        pokemons.add(new Pokemon("Diglett", 120, 170, 110, 240, TipoPokemon.TIERRA));
        pokemons.add(new Pokemon("Cubone", 200, 150, 240, 110, TipoPokemon.TIERRA));
        pokemons.add(new Pokemon("Marowak", 240, 200, 270, 130, TipoPokemon.TIERRA));
        pokemons.add(new Pokemon("Groudon", 330, 320, 290, 170, TipoPokemon.TIERRA));
    }

    public static PokemonRepository getInstance() {
        if(instance == null) instance = new PokemonRepository();
        return instance;
    }

    public List<Pokemon> getAll() {
        return pokemons;
    }

    public Pokemon getById(int id) {
        for(Pokemon p : pokemons) {
            if(p.getId() == id) return p;
        }
        return null;
    }

    public void add(Pokemon p) { pokemons.add(p); }

    public void update(int id, String nombre, int hp, int ataque, int defensa, int velocidad, TipoPokemon tipo) {
        Pokemon p = getById(id);
        if(p != null){
            p.setNombre(nombre);
            p.setHp(hp);
            p.setAtaque(ataque);
            p.setDefensa(defensa);
            p.setVelocidad(velocidad);
            p.setTipo(tipo);
        }
    }

    public boolean delete(int id) {
        Pokemon p = getById(id);
        if (p != null){
            pokemons.remove(p);
            return true;
        }
        return false;
    }
}
