package com.atom.application.controllers;

import java.util.List;

import com.atom.application.dtos.UserPermissionDTO;
import com.atom.application.services.UserPermissionFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
