package com.atom.application.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.atom.application.models.UserPermission;
import com.atom.application.repos.UserPermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {

    @Autowired
    private UserPermissionRepository repo;

    public List<UserPermission> getAllPermissions() {
        return repo.findAll();
    }

    public List<UserPermission> getAllPermissionsByNames(List<String> requestedPermissionNames) {
        List<UserPermission> storedPermissions = repo.findAllByNames(requestedPermissionNames);
        List<String> storedPermissionNames = storedPermissions.stream().map(UserPermission::getName).collect(Collectors.toList());
        requestedPermissionNames.removeAll(storedPermissionNames);
        if (!requestedPermissionNames.isEmpty()) {
            String namesString = requestedPermissionNames.stream().map(name -> "'" + name + "'").collect(Collectors.joining(", "));
            throw new EntityNotFoundException("No user permissions found with names: " + namesString);
        }
        return storedPermissions;
    }

}
