package com.atom.application.repos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.atom.application.models.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    public Optional<UserRole> findByName(String name);

    @Query("SELECT r FROM UserRole r WHERE r.name IN (:names)")
    public List<UserRole> findAllByNames(@Param("names") Collection<String> names);

}
