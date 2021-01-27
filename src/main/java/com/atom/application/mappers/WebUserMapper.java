package com.atom.application.mappers;

import com.atom.application.dtos.WebUserDTO;
import com.atom.application.models.UserRole;
import com.atom.application.models.WebUser;
import com.atom.application.services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebUserMapper implements EntityDTOMapper<WebUser, WebUserDTO> {

    @Autowired
    private UserRoleService roleService;

    @Override
    public WebUserDTO mapToDto(WebUser entity) {
        WebUserDTO dto = new WebUserDTO();
        dto.setActivated(entity.getActivated());
        dto.setLocked(entity.getLocked());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setId(entity.getId());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole().getName());
        dto.setUsername(entity.getUsername());
        return dto;
    }

    @Override
    public WebUser mapToEntity(WebUserDTO dto) {
        // * id not set by mapper
        WebUser entity = new WebUser();
        entity.setActivated(dto.getActivated());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setLocked(dto.getLocked());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        UserRole role = roleService.getUserRoleByName(dto.getRole());
        entity.setRole(role);
        return entity;
    }

    
    
}
