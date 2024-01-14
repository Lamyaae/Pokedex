package com.example.pokedex.models;

// PokemonData extending Pokemon
public class PokemonData extends Pokemon {
    private final String description;   // Additional description specific to fetched Pokemon data

    // Constructor.
    public PokemonData(int id, String name, String description, int height, int weight) {
        super(id, name, height, weight);
        this.description = description;
    }

    // Getter method to access the additional description.
    public String getDescription() {
        return description;
    }
}