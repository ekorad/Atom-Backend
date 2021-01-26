package com.atom.application.services;

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

    @Autowired
    private UserRoleRepository repo;

    public List<UserRole> getAllRoles() {
        return repo.findAll();
    }

    public UserRole addNewRole(UserRole role) {
        return repo.save(role);
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
        repo.deleteInBatch(roles);
    }

    public UserRole updateRole(String existingRoleName, UserRole role) {
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
