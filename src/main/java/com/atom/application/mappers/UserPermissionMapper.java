package com.atom.application.mappers;

import com.atom.application.dtos.UserPermissionDTO;
import com.atom.application.models.UserPermission;

import org.springframework.stereotype.Component;

@Component
public class UserPermissionMapper implements EntityDTOMapper<UserPermission, UserPermissionDTO> {

    @Override
    public UserPermissionDTO mapToDto(UserPermission entity) {
        UserPermissionDTO dto = new UserPermissionDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());
        return dto;
    }

    // * entity mapping is not required for user permissions but is added for consistency
    @Deprecated(forRemoval = true)
    @Override
    public UserPermission mapToEntity(UserPermissionDTO dto) {
        // * id not set by mapper
        UserPermission entity = new UserPermission();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return entity;
    }

}
