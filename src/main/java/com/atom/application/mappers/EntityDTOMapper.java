package com.atom.application.mappers;

/**
 * This is the interface implemented by classes which deal with entity to DTO
 * mapping.
 * 
 * @param <E> the type of the entity
 * @param <D> the type of the DTO
 */
public interface EntityDTOMapper<E, D> {

    /**
     * This function maps a given entity to a corresponding DTO
     * 
     * @param entity - the entity to be mapped to a DTO
     * @return the DTO
     */
    public D mapToDto(E entity);

    /**
     * This function maps a given DTO to a corresponding entity
     * 
     * @param dto - the DTO to be mapped to an entity
     * @return the entity
     */
    public E mapToEntity(D dto);

}
