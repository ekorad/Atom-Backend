package com.atom.application.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.atom.application.dtos.UserRoleDTO;
import com.atom.application.models.UserPermission;
import com.atom.application.models.UserRole;
import com.atom.application.services.UserPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleMapper implements EntityDTOMapper<UserRole, UserRoleDTO> {

    @Autowired
    private UserPermissionService service;

    @Override
    public UserRoleDTO mapToDto(UserRole entity) {
        UserRoleDTO dto = new UserRoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPermissions(entity.getPermissions().stream().map(UserPermission::getName).collect(Collectors.toSet()));
        return dto;
    }

    @Override
    public UserRole mapToEntity(UserRoleDTO dto) {
        // * id not set by mapper
        UserRole entity = new UserRole();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        List<UserPermission> permissions = service
                .getAllPermissionsByNames(dto.getPermissions().stream().collect(Collectors.toList()));
        entity.setPermissions(permissions.stream().collect(Collectors.toSet()));
        return entity;
    }

}
