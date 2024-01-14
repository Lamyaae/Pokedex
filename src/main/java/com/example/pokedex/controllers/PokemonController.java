package com.example.pokedex.controllers;
import com.example.pokedex.models.PokemonData;
import com.example.pokedex.services.PokemonService;
import com.example.pokedex.utils.OutputFormat;
import com.example.pokedex.views.ConsoleOutputView;

public class PokemonController {
    private final PokemonService apiPokemonService;        // Service for fetching Pokemon data from API.
    private final PokemonService databasePokemonService;   // Service for fetching Pokemon data from the local database.
    private final ConsoleOutputView outputView;            // View responsible for displaying Pokemon data.
    private OutputFormat outputFormat;               // Selected output format for displaying Pokemon data.

    // Constructor.
    public PokemonController(
            PokemonService apiPokemonService,
            PokemonService databasePokemonService,
            ConsoleOutputView outputView,
            OutputFormat outputFormat
    ) {
        this.apiPokemonService = apiPokemonService;
        this.databasePokemonService = databasePokemonService;
        this.outputView = outputView;
        this.outputFormat = outputFormat;
    }

    // Fetches Pokemon data based on the provided ID and database path,
    public void fetchAndDisplayPokemonData(int id, String databasePath) {
        // Attempt to fetch Pokemon data from the local database
        PokemonData pokemonData = databasePokemonService.getPokemonData(id, databasePath);

        // If data is not found in the local database, try fetching from the API
        if (pokemonData == null) {
            pokemonData = apiPokemonService.getPokemonData(id, null);
        }

        // Display the fetched Pokemon data using the specified output format by the user
        outputView.displayPokemonData(pokemonData);
    }
}
