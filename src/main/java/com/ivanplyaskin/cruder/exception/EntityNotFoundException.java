package com.ivanplyaskin.cruder.exception;


/**
 * A custom exception that occurs when an entity cannot be found by this identifier.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entityClass) {
        super(String.format("The %s with %s ID was not found", entityClass.getSimpleName(), id));
    }
}
