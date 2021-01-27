package com.atom.application.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.atom.application.models.UserRole;
import com.atom.application.repos.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    private final static String READONLY_ROLES[] = { "USER", "MODERATOR", "ADMIN" };

    @Autowired
    private UserRoleRepository repo;

    public List<UserRole> getAllRoles() {
        return repo.findAll();
    }

    public UserRole addNewRole(UserRole role) {
        return repo.save(role);
    }

    public UserRole getUserRoleByName(String name) {
        Optional<UserRole> persistedOpt = repo.findByName(name);
        if (!persistedOpt.isPresent()) {
            throw new EntityNotFoundException("No user role found with name: '" + name + "'");
        }
        UserRole persisted = persistedOpt.get();
        return persisted;
    }

    public List<UserRole> getAllUserRolesByNames(List<String> requestedRoleNames) {
        List<UserRole> storedRoles = repo.findAllByNames(requestedRoleNames);
        List<String> storedRoleNames = storedRoles.stream().map(UserRole::getName).collect(Collectors.toList());
        requestedRoleNames.removeAll(storedRoleNames);
        if (!requestedRoleNames.isEmpty()) {
            String namesString = requestedRoleNames.stream().map(name -> "'" + name + "'")
                    .collect(Collectors.joining(", "));
            throw new EntityNotFoundException("No user permissions found with names: " + namesString);
        }
        return storedRoles;
    }

    public void removeRoles(List<UserRole> roles) {
        List<String> roleNames = roles.stream().map(UserRole::getName).collect(Collectors.toList());
        List<String> readonlyNames = new ArrayList<>(Arrays.asList(READONLY_ROLES));
        readonlyNames.removeAll(roleNames);
        if (!readonlyNames.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove readonly user roles");
        }
        repo.deleteInBatch(roles);
    }

    public UserRole updateRole(String existingRoleName, UserRole role) {
        List<String> readonlyNames = Arrays.asList(READONLY_ROLES);
        if (readonlyNames.contains(existingRoleName)) {
            throw new IllegalArgumentException(
                    "Cannot modify readonly user role with name: '" + existingRoleName + "'");
        }

        Optional<UserRole> persistedOpt = repo.findByName(existingRoleName);
        if (!persistedOpt.isPresent()) {
            throw new EntityNotFoundException("A user role with name '" + existingRoleName + "' does not exist");
        }
        UserRole persisted = persistedOpt.get();
        persisted.setDescription(role.getDescription());
        persisted.setName(role.getName());
        persisted.setPermissions(role.getPermissions());
        return repo.save(persisted);
    }

}
