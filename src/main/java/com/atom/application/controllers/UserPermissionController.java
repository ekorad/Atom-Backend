package com.atom.application.controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.atom.application.dtos.UserPermissionDTO;
import com.atom.application.services.UserPermissionFacade;

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
    private UserPermissionFacade service;

    @GetMapping
    public List<UserPermissionDTO> getAllPermissions() {
        return service.getAllUserPermissions();
    }

    @GetMapping(params = "names")
    public List<UserPermissionDTO> getAllPermissionsByNames(
        @RequestParam(name = "names", required = true)
        @NotEmpty(message = "List of requested user permission names is mandatory and cannot be empty")
        List<@NotBlank(message = "User permission name within list is mandatory and must not contain only whitespace") 
            @Size(min = 5, max = 50, message = "User permission name within list must contain between 5 and 50 valid characaters") String> names) {
        return service.getAllUserPermissionsByNames(names);
    }
    
}
