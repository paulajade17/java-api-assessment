package com.cbfacademy.apiassessment.coffee;

import java.util.Collection;
import java.util.UUID;

import com.cbfacademy.apiassessment.core.PersistenceException;

/**
 * The CoffeeRepository interface defines operations for managing coffee entities in the system.
 * It provides methods for retrieving, saving, updating, and deleting coffee records and acts as the data store.
 * This interfaces serves as a contract for classes responsible for handling coffee related data operations.
 */
public interface CoffeeRepository {

     /**
     * Find all Coffee entities
     *
     * @return a collection of coffee entities.
     * @throws PersistenceException if there is an issue with data persistence.
     */


    Collection<Coffee> findAll() throws PersistenceException;

    /**
     * Finds a coffee entity by its unique identifier.
     *
     * @param id the identifier of the entity to find.
     * @return the found entity
     * @throws CoffeeNotFoundException if the requested coffee is not found
     * @throws PersistenceException if there's an issue with data persistence
     */

    Coffee findById(UUID id) throws CoffeeNotFoundException;

    /**
     * Saves a coffee entity (new or existing) in the repository.
     *
     * @param entity the Coffee entity to save
     * @return the saved Coffee entity
     * @throws IllegalArgumentException if the provided entity is not valid
     * @throws PersistenceException if there's an issue with data persistence
     */
    Coffee save(Coffee entity) throws IllegalArgumentException, PersistenceException;

     /**
     * Deletes a coffee entity from the repository based on its unique identifier.
     *
     * @param id the identifier of the entity to delete
     * @throws IllegalArgumentException if the provided identifier is not valid
     * @throws PersistenceException if there's an issue with data persistence
     */
    void deleteById(UUID id) throws IllegalArgumentException, PersistenceException;

}

    


