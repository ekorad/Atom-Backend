package com.atom.application.services;

import java.util.Collection;
import java.util.List;

import com.atom.application.models.UserPermission;
import com.atom.application.repos.UserPermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {

    @Autowired
    private UserPermissionRepository repo;

    public UserPermission getPermissionByName(String name) {
        return repo.findByName(name).orElse(null);
    }

    public List<UserPermission> getAllPermissions() {
        return repo.findAll();
    }

    public List<UserPermission> getAllPermissionsByNames(Collection<String> names) {
        return repo.findAllByNames(names);
    }

}
