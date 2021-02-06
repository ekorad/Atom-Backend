package com.atom.application.repos;

import com.atom.application.models.Command;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command, Long>{
    
}
