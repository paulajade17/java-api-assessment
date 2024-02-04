package com.cbfacademy.apiassessment.coffee;

import java.util.Collection;
import java.util.UUID;

import com.cbfacademy.apiassessment.core.PersistenceException;

/**
 * The CoffeeRepository interface defines the operations for managing coffees in the system.
 * It provides methods for retrieving, saving, updating, and deleting coffee records.
 */
public interface CoffeeRepository {

    Collection<Coffee> findAll() throws PersistenceException;

    /**
     * Finds an entity by its unique identifier.
     *
     * @param id the identifier of the entity
     * @return the found entity, or null if no such entity exists
     */
    Coffee findById(UUID id) throws IllegalArgumentException, PersistenceException;

    /**
     * Saves an entity (new or existing) in the repository.
     *
     * @param entity the {@code <T>} to save
     * @return the saved entity
     */
    Coffee save(Coffee entity) throws IllegalArgumentException, PersistenceException;

    /**
     * Deletes an entity from the repository based on its unique identifier.
     *
     * @param id the id of the entity to delete
     */
    void deleteById(UUID id) throws IllegalArgumentException, PersistenceException;

}

    


