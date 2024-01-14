package com.example.pokedex;

import com.example.pokedex.controllers.PokemonController;
import com.example.pokedex.services.*;

import com.example.pokedex.services.ApiPokemonService;
import com.example.pokedex.services.DatabasePokemonService;
import com.example.pokedex.utils.OutputFormat;
import com.example.pokedex.views.ConsoleOutputView;

// Pokedex class contains the main method that is runnable.
public class Pokedex {
    public static void main(String[] args) {
        // Instantiate services and views

        PokemonService apiPokemonService = new ApiPokemonService();
        PokemonService databasePokemonService = new DatabasePokemonService();

        OutputFormat outputFormat = OutputFormat.TEXT; // Set a default output format

        // Check for the presence of '-f' in the arguments
        for (int i = 0; i < args.length - 1; i++) {
            if ("-f".equals(args[i])) {
                outputFormat = OutputFormat.valueOf(args[i + 1].toUpperCase());
                break;
            }
        }

        ConsoleOutputView outputView = new ConsoleOutputView(outputFormat);

        // Instantiate the controller
        PokemonController pokemonController = new PokemonController(apiPokemonService, databasePokemonService, outputView, outputFormat);

        // Parse command-line arguments and fetch/display Pokemon data
        try {
            int pokemonId = Integer.parseInt(args[0]);
            String databasePath = null;

            if (args.length > 1 && args[1].equals("-d")) {
                databasePath = args[2];
                pokemonController.fetchAndDisplayPokemonData(pokemonId, databasePath);
            } else {
                pokemonController.fetchAndDisplayPokemonData(pokemonId, null);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
