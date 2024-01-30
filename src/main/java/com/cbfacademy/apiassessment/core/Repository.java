package com.cbfacademy.apiassessment.core;

import java.util.Optional;

public interface Repository<T, ID> extends org.springframework.data.repository.Repository<T, ID> {

    /**
     * Retrieves all entities from the repository.
     *
     * @return a list of all entities
     */
    Iterable<T> findAll();

    /**
     * Finds an entity by its unique identifier.
     *
     * @param id the identifier of the entity
     * @return the found entity, or null if no such entity exists
     */
    Optional<T> findById(ID id);

    /**
     * Saves an entity (new or existing) in the repository.
     *
     * @param entity the {@code <T>} to save
     * @return the saved entity
     */
    <S extends T> S save(S entity);

    /**
     * Deletes an entity from the repository based on its unique identifier.
     *
     * @param id the id of the entity to delete
     */
    void deleteById(ID id);

}