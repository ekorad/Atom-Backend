package com.atom.application.repos;

import java.util.Optional;

import com.atom.application.models.UserPermission;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    
    public Optional<UserPermission> findByName(String name);

}
