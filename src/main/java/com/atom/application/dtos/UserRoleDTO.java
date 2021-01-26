package com.atom.application.dtos;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRoleDTO {

    private Long id;

    @NotBlank(message = "User role name is mandatory and must not contain only whitespace")
    @Size(min = 5, max = 50, message = "User role name must contain between 5 and 50 characters")
    private String name;

    @NotBlank(message = "User role description is mandatory and must not contain only whitespace")
    @Size(min = 5, max = 255, message = "User role description must contain between 5 and 255 characters")
    private String description;

    @NotEmpty(message = "Associated permission list is mandatory and must not be empty")
    private Set<@NotBlank(message = "User permission name is mandatory and cannot contain only whitespace") 
        @Size(min = 5, max = 50, message = "User permission name must contain between 5 and 50 valid characters") String> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

}
