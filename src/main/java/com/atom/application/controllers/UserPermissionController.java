package com.atom.application.controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.atom.application.models.UserPermission;
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

    @GetMapping
    public List<UserPermission> getAllPermissions() {
        return service.getAllPermissions();
    }

    @GetMapping(params = "permissionName")
    public UserPermission getPermissionByName(
        @RequestParam(name = "permissionName")
        @NotBlank(message = "Permission name is mandatory and must not contain only whitespace")
        @Size(min = 4, max = 50, message = "Permission name must contain between 4 and 50 characters")
        String name
    ) {
        return service.getPermissionByName(name);
    }
}
