package com.atom.application.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class WebUserDTO {

    private Long id;

    @NotBlank(message = "User first name is mandatory and cannot contain only whitespace")
    @Size(min = 2, max = 30, message = "User first name must contain between 2 and 30 valid characters")
    private String firstName;

    @NotBlank(message = "User last name is mandatory and cannot contain only whitespace")
    @Size(min = 2, max = 30, message = "User last name must contain between 2 and 30 valid characters")
    private String lastName;

    @NotBlank(message = "User username is mandatory and cannot contain only whitespace")
    @Size(min = 5, max = 30, message = "User username must contain between 5 and 30 valid characters")
    private String username;

    @NotBlank(message = "User email is mandatory and cannot contain only whitespace")
    @Size(min = 5, max = 70, message = "User email must contain between 5 and 70 valid characters")
    private String email;

    @NotBlank(message = "User password is mandatory and cannot contain only whitespace")
    @Size(min = 8, max = 255, message = "User password must contain between 8 and 255 valid characters")
    private String password;

    @NotBlank(message = "User role name is mandatory and must not contain only whitespace")
    @Size(min = 5, max = 50, message = "User role name must contain between 5 and 50 characters")
    private String role;

    private Boolean locked;
    private Boolean activated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
