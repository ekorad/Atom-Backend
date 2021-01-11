package com.atom.application.mappers;

import com.atom.application.dtos.UserPermissionDTO;
import com.atom.application.models.UserPermission;

import org.springframework.stereotype.Component;

@Component
public class UserPermissionMapper {
    
    public UserPermissionDTO mapToDto(UserPermission entity) {
        UserPermissionDTO dto = new UserPermissionDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());
        return dto;
    }

    public UserPermission mapToEntity(UserPermissionDTO dto) {
        UserPermission entity = new UserPermission();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        return entity;
    }

}
