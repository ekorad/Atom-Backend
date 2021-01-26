package com.atom.application.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.atom.application.dtos.UserRoleDTO;
import com.atom.application.mappers.UserRoleMapper;
import com.atom.application.models.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleFacade {

    @Autowired
    private UserRoleService service;
    @Autowired
    private UserRoleMapper mapper;

    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> entities = service.getAllRoles();
        return entities.stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    public void addNewUserRole(UserRoleDTO newUserRoleDTO) {
        UserRole entity = mapper.mapToEntity(newUserRoleDTO);
        service.addNewRole(entity);
    }

    public void updateExistingUserRole(String existingRoleName, UserRoleDTO editedUserRoleDTO) {
        UserRole entity = null;
        try {
            entity = mapper.mapToEntity(editedUserRoleDTO);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException(
                    "No user role found with the specified user permissions (" + ex.getLocalizedMessage() + ")");
        }
        service.updateRole(existingRoleName, entity);
    }

    public void deleteUserRolesByName(List<String> existingRoleNames) {
        List<UserRole> persistedRoles = service.getAllUserRolesByNames(existingRoleNames);
        service.removeRoles(persistedRoles);
    }

}
