package com.atom.application.services;

import java.util.List;


import com.atom.application.models.Command;
import com.atom.application.repos.CommandRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    @Autowired
    private CommandRepository repo;
    
    
    public List<Command> getAllCommands() {
        return repo.findAll();
    }

    public Command addNewCommand(Command newCommand) {
        return repo.save(newCommand);
    }
}
