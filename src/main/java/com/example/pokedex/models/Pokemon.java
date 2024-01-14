package com.example.pokedex.models;

public class Pokemon {
    private final int id;               // Pokemon ID
    private final String name;          // Pokemon name
    private final int height;           // Pokemon height
    private final int weight;           // Pokemon weight

    // Constructor
    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Getter methods to access Pokemon attributes.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

}