package com.example.pokedex.services;

import org.apache.http.HttpResponse;

import com.example.pokedex.models.PokemonData;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

// ApiPokemonService implements PokemonService and provides a method to fetch Pokemon data from the PokeAPI based on the given ID
public class ApiPokemonService implements PokemonService {

    @Override
    public PokemonData getPokemonData(int id, String databasePath) {
        // Implementation of getPokemonData using API
        String jsonResponse = "";
        try {
            // Create an HTTP client
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            // Create an HTTP GET request to the PokeAPI
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/" + id);
            request.addHeader("content-type", "application/json");

            // Execute the request and obtain the JSON response
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");
            System.out.println("Instead, Connection to API has been established.");

            // Parse the JSON response
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);

            // Check if the result is a JSON object
            if (resultObject instanceof JSONObject) {
                JSONObject obj = (JSONObject) resultObject;
                String name = obj.get("name").toString();
                int weight = Integer.parseInt(obj.get("weight").toString());
                int height = Integer.parseInt(obj.get("height").toString());

                // Return PokemonData with retrieved information
                return new PokemonData(id, name, "No description found in the API", height, weight);
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}