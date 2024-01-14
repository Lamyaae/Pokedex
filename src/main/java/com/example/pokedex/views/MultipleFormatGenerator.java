package com.example.pokedex.views;


import com.example.pokedex.models.PokemonData;

// MultipleFormatGenerator is an interface that defines methods for generating output in multiple formats based on the given argument.
public interface MultipleFormatGenerator {
    String generateHTML(PokemonData pokemonData);
    String generateCSV(PokemonData pokemonData);
    String generateHumanReadableText(PokemonData pokemonData);
}
