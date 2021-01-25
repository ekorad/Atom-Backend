package com.atom.application.repos;

import com.atom.application.models.UserPermission;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {

}
