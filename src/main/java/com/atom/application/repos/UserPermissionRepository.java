package com.atom.application.repos;

import java.util.Collection;
import java.util.List;

import com.atom.application.models.UserPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <b>User permissions repository</b>
 * <p>
 * It is used as an interface between the database and the higher-level services
 * that require access to user permissions.
 * 
 * @see {@link com.atom.application.models.UserPermission UserPermission}
 */
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {

    /**
     * Retrieves a list of all the user permissions whose names that match a given
     * list of names.
     * 
     * @param names - a <code>Collection</code> of permission names that are being
     *              searched for
     * @return a <code>List</code> containing all the user permissions entities
     *         which match the requested names
     */
    @Query("SELECT p FROM UserPermission p WHERE p.name IN (:names)")
    public List<UserPermission> findAllByNames(@Param("names") Collection<String> names);

}
