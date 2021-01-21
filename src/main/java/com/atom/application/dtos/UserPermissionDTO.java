package com.atom.application.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserPermissionDTO {

    private Long id;

    // * validation is not required for permissions DTOs but is added consistency

    @NotBlank(message = "User permission name is mandatory and cannot contain only whitespace")
    @Size(min = 5, max = 50, message = "User permission name must contain between 5 and 50 valid characters")
    private String name;

    @NotBlank(message = "User permission description is mandatory and cannot contain only whitespace")
    @Size(min = 5, max = 50, message = "User permission description must contain between 5 and 255 valid characters")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
