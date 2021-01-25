package com.atom.application.services;

import java.util.List;

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

}
