package com.atom.application.repos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.atom.application.models.WebUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {

    public Optional<WebUser> findByUsername(String username);

    public Optional<WebUser> findByEmail(String email);

    @Query("SELECT u FROM WebUser u WHERE u.username IN (:usernames)")
    public List<WebUser> findAllByNames(@Param("usernames") Collection<String> usernames);

}
