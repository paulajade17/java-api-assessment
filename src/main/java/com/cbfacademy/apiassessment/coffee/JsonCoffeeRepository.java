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
 * and uses a JSON file as a data store for coffee objects
 */
@Repository
public class JsonCoffeeRepository implements CoffeeRepository {
    // File path is a string where the file is stored
    // File path to the JSON file
    private final String filePath;

    // Gson allows you to convert Java objects to JSON strings and vice versa
    private final Gson gson;

    // Map to hold coffee objects called database
    private final Map<UUID, Coffee> database;

    /**
     * Constructor for JsonCoffeeRepository.
     * Initializes the file path, creates new Gson instance, and loads data from the JSON file.
     *
     * @param filePath is a string representing the path to a JSON file containing coffee data.
     */
    // @Value injects the file "src/main/resources/static/database.json" into the filePath parameter
    // The constructor initializes a JsonCoffeeRepository object by injecting the path to a JSON file 
    // containing coffee data and then loading the data from the Json file, into a data structure using Gson.
    public JsonCoffeeRepository(@Value("src/main/resources/static/database.json") String filePath) {
        this.filePath = filePath;
          // Create a new Gson instance with default settings
        gson = new GsonBuilder()
                .create();
        //  Uses loadDataFromJSON() method to load data from the JSON file into the map of coffee objects   
        database = loadDataFromJson();
    }

     /**
     * Reads data from the JSON file and deserialises it into the map of coffee objects.
     *
     * @return A Map representing the coffees
     */
    private Map<UUID, Coffee> loadDataFromJson() {
        // Initialises Reader object called reader
        // Try block ensures the Reader is closed properly
        // If an exception is caught the Reader will be closed
        // Use filereader to read from Json file 
        try (Reader reader = new FileReader(filePath)) {
             // Defines the type for deserialization using Gson
            Type type = new TypeToken<Map<UUID, Coffee>>() {
            }.getType();
            // Deserialize allows you to convert JSON strings into a Java objects
            // Deserialize the JSON data read from the reader and converts it into a map of coffe objects.
            return gson.fromJson(reader, type);
            // catches any IOException that might occur during the file reading process
        } catch (IOException e) {
            // prints the stack trace of the exception, if exception is caught
            e.printStackTrace();
        }
        return new HashMap<>();
    }
    /**
     * Saves the map to the JSON file.
     * Attempts to write the data of the hash map in JSON format to the JSON file
     */
    private void saveDataToJson() {
        // try catch block to ensure files are closed properly.
        // Writer object named writer is created using a FileWriter initialized with the JSON file
        try (Writer writer = new FileWriter(filePath)) {
            // Serialize allows you to convert Java objects into JSON strings
            // Serializes the hash map to JSON format and writes it to JSON file
            gson.toJson(database, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retrieves all coffee objects from the hash map.
     *
     * @return A Collection of Coffee objects.
     */
    @Override
    public Collection<Coffee> findAll() {
        return database.values();
    }

     /**
     * Retrieves a coffee entity from the map based on its unique identifier.
     *
     * @param id The unique identifier of the coffee to retrieve.
     * @return The Coffee object with the specified ID, or null if not found.
     */
    @Override
    public Coffee findById(UUID id) {
        return database.get(id);
    }
    /**
     * Saves a new or existing coffee entity to the hash map and updates the JSON file.
     *
     * @param entity The Coffee object to save.
     * @return The saved Coffee object.
     */

    @Override
    // When a new coffee is saved using the save (Coffee enity) method it is added to the map.
    public Coffee save(Coffee entity) {
        // Put the coffee into the hash map by using getId() as the key and 'enity' as the value.
        database.put(entity.getId(), entity);
        // Save the updated hash map to the JSON file
        saveDataToJson();

        return entity;
    }
    /**
     * Deletes a coffee from the hash map by its unique identifier and updates the JSON file.
     *
     * @param id The unique identifier of the coffee to delete.
     */
    @Override
    public void deleteById(UUID id) {
        // Removes the coffee with the specified UUID from the hash map
        database.remove(id);
        // Saves the updated hash map to the JSON file
        saveDataToJson();
    }
    
}
