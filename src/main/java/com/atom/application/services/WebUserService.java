package com.atom.application.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.atom.application.models.WebUser;
import com.atom.application.repos.WebUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {

    @Autowired
    private WebUserRepository repo;

    public List<WebUser> getAllWebUsers() {
        return repo.findAll();
    }

    public List<WebUser> getAllWebUsersByUsernames(List<String> requestedUsernames) {
        List<WebUser> storedWebUsers = repo.findAllByNames(requestedUsernames);
        List<String> storedUsernames = storedWebUsers.stream().map(WebUser::getUsername).collect(Collectors.toList());
        requestedUsernames.removeAll(storedUsernames);
        if (!requestedUsernames.isEmpty()) {
            String namesString = requestedUsernames.stream().map(name -> "'" + name + "'")
                    .collect(Collectors.joining(", "));
            throw new EntityNotFoundException("No user accounts found with usernames: " + namesString);
        }
        return storedWebUsers;
    }

    public WebUser getWebUserByUsername(String username) {
        Optional<WebUser> persistedOpt = repo.findByUsername(username);
        if (!persistedOpt.isPresent()) {
            throw new EntityNotFoundException("No user account found with username: '" + username + "'");
        }
        WebUser persisted = persistedOpt.get();
        return persisted;
    }

    public WebUser getWebUserByEmail(String email) {
        Optional<WebUser> persistedOpt = repo.findByEmail(email);
        if (!persistedOpt.isPresent()) {
            throw new EntityNotFoundException("No user account found with email: '" + email + "'");
        }
        WebUser persisted = persistedOpt.get();
        return persisted;
    }

    public WebUser addNewWebUser(WebUser user) {
        return repo.save(user);
    }

    public void removeWebUsers(List<WebUser> users) {
        repo.deleteInBatch(users);
    }

    public WebUser updateWebUser(String existingUsername, WebUser user) {
        Optional<WebUser> persistedOpt = repo.findByUsername(existingUsername);
        if (!persistedOpt.isPresent()) {
            throw new EntityNotFoundException("A user account with username '" + existingUsername + "' does not exist");
        }
        WebUser persisted = persistedOpt.get();
        persisted.setActivated(user.getActivated());
        persisted.setEmail(user.getEmail());
        persisted.setFirstName(user.getFirstName());
        persisted.setLastName(user.getLastName());
        persisted.setLocked(user.getLocked());
        persisted.setPassword(user.getPassword());
        persisted.setRole(user.getRole());
        persisted.setUsername(user.getUsername());
        return repo.save(persisted);
    }

}
