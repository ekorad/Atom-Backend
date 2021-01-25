package com.atom.application.services;

import java.util.List;
import java.util.stream.Collectors;

import com.atom.application.dtos.UserPermissionDTO;
import com.atom.application.mappers.UserPermissionMapper;
import com.atom.application.models.UserPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionFacade {

    @Autowired
    private UserPermissionService service;
    @Autowired
    private UserPermissionMapper mapper;

    public List<UserPermissionDTO> getAllUserPermissions() {
        List<UserPermission> entities = service.getAllPermissions();
        return entities.stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    public List<UserPermissionDTO> getAllUserPermissionsByNames(List<String> requestedPermissionNames) {
        List<UserPermission> entities = service.getAllPermissionsByNames(requestedPermissionNames);
        return entities.stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

}
