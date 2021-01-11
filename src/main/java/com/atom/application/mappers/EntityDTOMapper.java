package com.atom.application.mappers;

public interface EntityDTOMapper<E, D> {
    
    public D mapToDto(E entity);
    public E mapToEntity(D dto);
    
}
