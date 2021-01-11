package com.atom.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.atom.application.dtos.UserPermissionDTO;
import com.atom.application.mappers.UserPermissionMapper;
import com.atom.application.services.UserPermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/permissions")
@Validated
public class UserPermissionController {
    
    @Autowired
    private UserPermissionService service;
    @Autowired
    private UserPermissionMapper mapper;

    @GetMapping
    public List<UserPermissionDTO> getAllPermissions() {
        return service.getAllPermissions().stream().map(mapper::mapToDto)
            .collect(Collectors.toList());
    }

    @GetMapping(params = "permissionName")
    public UserPermissionDTO getPermissionByName(
        @RequestParam(name = "permissionName")
        @NotBlank(message = "Permission name is mandatory and must not contain only whitespace")
        @Size(min = 4, max = 50, message = "Permission name must contain between 4 and 50 characters")
        String name) {
        return mapper.mapToDto(service.getPermissionByName(name));
    }

    @GetMapping(params = "permissionNames")
    public List<UserPermissionDTO> getAllPermissionsByNames(
        @RequestParam(name = "permissionNames")
        @NotEmpty(message = "List of user permission names is mandatory and cannot be empty")
        List<@NotBlank(message = "User permission name is mandatory and must not contain only whitespace") 
            @Size(min = 5, max = 50, message = "User permission name must contain between 5 and 50 characaters") String> names) {
        return service.getAllPermissionsByNames(names).stream()
            .map(mapper::mapToDto).collect(Collectors.toList());
    }
    
}
