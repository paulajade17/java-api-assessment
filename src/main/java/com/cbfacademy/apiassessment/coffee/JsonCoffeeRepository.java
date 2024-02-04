package com.cbfacademy.apiassessment.coffee;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * The JsonCoffeeRepository class implements the CoffeeRepository interface
 * and uses a JSON file as a data store for coffee entities.
 */
@Repository
public class JsonCoffeeRepository implements CoffeeRepository {
    // File path to the JSON database
    private final String filePath;

    // Gson instance for JSON serialization and deserialization
    private final Gson gson;

    //In-memory database (Map) to hold coffee entities
    private final Map<UUID, Coffee> database;

    /**
     * Constructor for JsonCoffeeRepository.
     * Initializes the file path, Gson instance, and loads data from the JSON file.
     *
     * @param filePath The file path to the JSON database.
     */
    public JsonCoffeeRepository(@Value("src/main/resources/static/database.json") String filePath) {
        this.filePath = filePath;
          // Create Gson instance with default settings
        gson = new GsonBuilder()
                .create();
        // Load data from the JSON file into the in-memory database    
        database = loadDataFromJson();
    }

     /**
     * Loads data from the JSON file into the in-memory database.
     *
     * @return A Map representing the in-memory database.
     */
    private Map<UUID, Coffee> loadDataFromJson() {
        try (Reader reader = new FileReader(filePath)) {
             // Define the type for deserialization using Gson
            Type type = new TypeToken<Map<UUID, Coffee>>() {
            }.getType();
            // Deserialize the JSON data into a Map
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
    /**
     * Saves the in-memory database to the JSON file.
     */
    private void saveDataToJson() {
        try (Writer writer = new FileWriter(filePath)) {
             // Serialize the in-memory database and write to the JSON file
            gson.toJson(database, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retrieves all coffee entities from the in-memory database.
     *
     * @return A Collection of Coffee objects representing all coffees.
     */
    @Override
    public Collection<Coffee> findAll() {
        return database.values();
    }

     /**
     * Retrieves a coffee entity by its unique identifier.
     *
     * @param id The unique identifier of the coffee to retrieve.
     * @return The Coffee object with the specified ID, or null if not found.
     */
    @Override
    public Coffee findById(UUID id) {
        return database.get(id);
    }
    /**
     * Saves a new or existing coffee entity to the in-memory database and updates the JSON file.
     *
     * @param entity The Coffee object to save.
     * @return The saved Coffee object.
     */
    @Override
    public Coffee save(Coffee entity) {
        // Put the coffee entity into the in-memory database
        database.put(entity.getId(), entity);
        // Save the updated in-memory database to the JSON file
        saveDataToJson();

        return entity;
    }
    /**
     * Deletes a coffee entity from the in-memory database by its unique identifier and updates the JSON file.
     *
     * @param id The unique identifier of the coffee to delete.
     */
    @Override
    public void deleteById(UUID id) {
        // Remove the coffee entity from the in-memory database
        database.remove(id);
        // Save the updated in-memory database to the JSON file
        saveDataToJson();
    }
    
}
