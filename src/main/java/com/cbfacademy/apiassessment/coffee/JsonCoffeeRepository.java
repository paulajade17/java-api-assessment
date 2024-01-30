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
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class JsonCoffeeRepository implements CoffeeRepository {
    private final String filePath;
    private final Gson gson;
    private final Map<UUID, Coffee> database;

    public JsonCoffeeRepository(@Value("src/main/resources/database.json") String filePath) {
        this.filePath = filePath;
        gson = new GsonBuilder()
                .create();
        database = loadDataFromJson();
    }

    private Map<UUID, Coffee> loadDataFromJson() {
        try (Reader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Map<UUID, Coffee>>() {
            }.getType();

            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private void saveDataToJson() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(database, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Coffee> findAll() {
        return database.values();
    }

     /**
     * Optional is used when a value might be absent
     * This helps avoid the need of explicit null checks
     */
    @Override
    public Optional<Coffee> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public <S extends Coffee> S save(S entity) {
        database.put(entity.getId(), entity);
        saveDataToJson();

        return entity;
    }

    @Override
    public void deleteById(UUID id) {
        database.remove(id);
        saveDataToJson();
    }

    @Override
    public Coffee searchByName(String name) {
        return database.values().stream().filter(coffee -> coffee.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Coffee> searchByBrand(String brand) {
        return database.values().stream().filter(coffee -> coffee.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Coffee> searchByOrigin(String origin) {
        return database.values().stream().filter(coffee -> coffee.getOrigin().equals(origin)).collect(Collectors.toList());
    }
    
}
