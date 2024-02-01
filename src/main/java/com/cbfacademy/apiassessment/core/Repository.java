package com.cbfacademy.apiassessment.core;

import java.util.Optional;

public interface Repository<T, ID> extends org.springframework.data.repository.Repository<T, ID> {

    /**
     * Retrieves all entities from the repository.
     * Iterable represents a sequence of elements that can be looped through
     * @return a list of all entities
     */
    Iterable<T> findAll() throws PersistenceException;

    /**
     * Finds an entity by its unique identifier.
     *
     * @param id the identifier of the entity
     * @return the found entity, or null if no such entity exists
     */
    Optional<T> findById(ID id) throws IllegalArgumentException, PersistenceException;

    /**
     * Saves an entity (new or existing) in the repository.
     *
     * @param entity the {@code <T>} to save
     * @return the saved entity
     */
    <S extends T> S save(S entity) throws IllegalArgumentException, PersistenceException;

    /**
     * Deletes an entity from the repository based on its unique identifier.
     *
     * @param id the id of the entity to delete
     */
    void deleteById(ID id) throws IllegalArgumentException, PersistenceException;

}