package com.example.pokedex.services;

import com.example.pokedex.models.PokemonData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DatabasePokemonService implements PokemonService and provides a method to fetch Pokemon data from a local SQLite database based on the given ID.
public class DatabasePokemonService implements PokemonService {

    @Override
    public PokemonData getPokemonData(int id, String databasePath) {
        // Implementation of getPokemonData using the local database
        Connection conn = null;
        try {
            // Set up the database connection
            String url = "jdbc:sqlite:" + databasePath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            // Prepare and execute a SQL query to retrieve Pokemon data
            PreparedStatement stmt = conn.prepareStatement("SELECT name, description, height, weight FROM pokemons WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            // Retrieve Pokemon attributes from the database result set
            String name = rs.getString("name");
            String description = rs.getString("description");
            int height = rs.getInt("height");
            int weight = rs.getInt("weight");

            // Return PokemonData with retrieved information
            return new PokemonData(id, name, description, height, weight);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the database connection in the final block.
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }
}
