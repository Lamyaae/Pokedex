package com.example.pokedex.views;

import com.example.pokedex.models.PokemonData;
import com.example.pokedex.utils.OutputFormat;

// ConsoleOutputView is a class that implements the MultipleFormatGenerator interface.
// It is responsible for generating output in various formats (HTML, CSV, human-readable text) based on the chosen OutputFormat.
public class ConsoleOutputView implements MultipleFormatGenerator {
    private final OutputFormat outputFormat;

    // Constructor.
    public ConsoleOutputView(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    // Generating Data in an HTML format.
    @Override
    public String generateHTML(PokemonData pokemonData) {
        return "<h1>" + pokemonData.getName() + "</h1>\n" +
                "<ul>\n" +
                "<li>Id: " + pokemonData.getId() + "</li>\n" +
                "<li>Height: " + pokemonData.getHeight() + "</li>\n" +
                "<li>Weight: " + pokemonData.getWeight() + "</li>\n" +
                "<li>Description: " + pokemonData.getDescription() + "</li>\n" +
                "</ul>";
    }

    // Generating Data in a CSV format.
    @Override
    public String generateCSV(PokemonData pokemonData) {
        return "Id;Name;Height;Weight;Description\n" +
                pokemonData.getId()+";"+
                pokemonData.getName() + ";" +
                pokemonData.getHeight() + ";" +
                pokemonData.getWeight() + ";" +
                pokemonData.getDescription();
    }

    // Generating Data in a TEXT format.
    @Override
    public String generateHumanReadableText(PokemonData pokemonData) {
        StringBuilder output = new StringBuilder("=============================\n");
        output.append("Pokemon # ").append(pokemonData.getId()).append("\n");
        output.append("Nom : ").append(pokemonData.getName()).append("\n");
        output.append("Taille : ").append(pokemonData.getHeight()).append("\n");
        output.append("Poids : ").append(pokemonData.getWeight()).append("\n");
        if (pokemonData.getDescription() != null) {
            output.append("Description : ").append(pokemonData.getDescription()).append("\n");
        }
        output.append("=============================");
        return output.toString();
    }

    public void displayPokemonData(PokemonData pokemonData) {
        // Switch statement to determine the output format and call the respective generation method.
        switch (outputFormat) {
            case TEXT -> System.out.println(generateHumanReadableText(pokemonData));
            case HTML -> System.out.println(generateHTML(pokemonData));
            case CSV -> System.out.println(generateCSV(pokemonData));
            default -> System.err.println("Unsupported output format");
        }
    }

}
