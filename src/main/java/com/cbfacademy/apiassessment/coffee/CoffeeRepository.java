package com.cbfacademy.apiassessment.coffee;

import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.core.Repository;

/**
 * The CoffeeRepository interface defines the operations for managing coffees in the system.
 * It provides methods for retrieving, saving, updating, and deleting coffee records.
 */
public interface CoffeeRepository extends Repository<Coffee, UUID> {

    /**
     * Searches for coffees where the name matches the provided string.
     *
     * @param name the name of the coffee
     * @return a coffee that matches the name
     */
    Coffee searchByName(String name);

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
