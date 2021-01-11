package com.atom.application.repos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.atom.application.models.UserPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    
    public Optional<UserPermission> findByName(String name);

    @Query("SELECT p FROM UserPermission p WHERE p.name IN (:names)")
    public List<UserPermission> findAllByNames(@Param("names") Collection<String> names);

}
