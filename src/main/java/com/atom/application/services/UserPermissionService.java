package com.atom.application.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.atom.application.models.UserPermission;
import com.atom.application.repos.UserPermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>User permissions service</b>
 * <p>
 * This service allows for direct interaction with the persisted user
 * permissions through the use of a <code>UserPermissionRepository</code>.
 * @see {@link com.atom.application.repos.UserPermissionRepository UserPermissionRepository}
 * @see {@link com.atom.application.models.UserPermission UserPermission}
 */
@Service
public class UserPermissionService {

    /**
     * The repository used for direct access to the persisted user permission entities.
     */
    @Autowired
    private UserPermissionRepository repo;

    /**
     * Retrieves all the existing user permissions.
     * @return a <code>List</code> of all the existing user permission entities
     */
    public List<UserPermission> getAllPermissions() {
        return repo.findAll();
    }

    /**
     * Retrieves all the existing user permissions according to given list of requested names.
     * @param requestedPermissionNames - a <code>List</code> of user permission entity names which are being searched for
     * @return a <code>List</code> of all the existing user permission entities with matching names
     * @throws EntityNotFoundException if not all of the requested user permission entities can be found
     */
    public List<UserPermission> getAllPermissionsByNames(List<String> requestedPermissionNames) {
        List<UserPermission> storedPermissions = repo.findAllByNames(requestedPermissionNames);
        List<String> storedPermissionsNames = storedPermissions.stream().map(UserPermission::getName)
                .collect(Collectors.toList());
        requestedPermissionNames.removeAll(storedPermissionsNames);
        if (!requestedPermissionNames.isEmpty()) {
            String namesString = requestedPermissionNames.stream().map(name -> "'" + name + "'")
                    .collect(Collectors.joining(", "));
            throw new EntityNotFoundException("No user permissions found with names: " + namesString);
        }
        return storedPermissions;
    }

}
