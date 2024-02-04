package com.cbfacademy.apiassessment.coffee;

import java.util.List;
import java.util.UUID;

public interface CoffeeService {

    /**
     * Retrieve a list of all coffees.
     *
     * @return A list of all coffees.
     */
    List<Coffee> getAllCoffees();

    /**
     * Retrieve a coffee by its ID.
     *
     * @param id The ID of the coffee to retrieve.
     * @return The coffee with the specified ID, or null if not found.
     */
    Coffee getCoffee(UUID id);

    /**
     * Create a new coffee.
     *
     * @param Coffee The coffee object to create.
     * @return The created coffee.
     */
    Coffee createCoffee(Coffee coffee);

    /**
     * Update an existing coffee by its ID.
     *
     * @param id         The ID of the coffee to update.
     * @param updatedCoffee The updated coffee object.
     * @return The updated coffee, or null if the ID is not found.
     */
    Coffee updateCoffee(UUID id, Coffee updatedCoffee);

    /**
     * Delete a coffee by its ID.
     *
     * @param id The ID of the coffee to delete.
     */
    void deleteCoffee(UUID id);


    List<Coffee> sortCoffeesByPrice();

    /**
     * Searches for coffees where the name matches the provided string.
     *
     * @param name the name of the coffee
     * @return a coffee that matches the name
     */
    Coffee searchByName(String name) throws CoffeeNotFoundException;

    /**
     * Searches for coffees where the brand's name matches the provided string.
     *
     * @param name the name of the coffee brand
     * @return a list of coffees that match the brand's name
     */
    List<Coffee> searchByBrand(String brand);

     /**
     * Searches for coffees where the origin name matches the provided string.
     *
     * @param name the origin of the coffee
     * @return a list of coffees that match the origin
     */
    List<Coffee> searchByOrigin(String origin);

}