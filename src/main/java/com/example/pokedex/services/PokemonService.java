package com.example.pokedex.services;

import com.example.pokedex.models.PokemonData;

// PokemonService is an interface defining a contract for classes that provide the functionality to fetch Pokemon data based on the Pokemon ID.
public interface PokemonService {
    // getPokemonData is a method signature that takes a Pokemon ID and a databasePath as parameters and returns PokemonData.
    PokemonData getPokemonData(int id, String databasePath);
}
