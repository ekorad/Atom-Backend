package com.atom.application.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <b>The DTO mapping of the user permission entity</b>
 * <p>
 * This is a DTO (Data Transfer Object) which implies that in essence it is a
 * "lesser" version of an entity which is subject to validation and is easier to
 * transfer through the HTTP protocol.
 * <p>
 * As user permissions are read-only, DTO validation is kept purely for
 * consistency, and has no real use.
 * <p>
 * In this case, it is the DTO mapping of the user permission entity
 * (<code>UserPermission</code>)
 * 
 * @see {@link com.atom.application.models.UserPermission UserPermission}
 */
public class UserPermissionDTO {

    /**
     * The <code>id</code> of a user permission.
     * <p>
     * For further details, see the definition of
     * {@link com.atom.application.models.UserPermission#id UserPermission.id}
     * <p>
     * The <code>id</code> will be used only for output purposes, as new ids are
     * generated automatically.
     */
    private Long id;

    /**
     * The <code>name</code> of a user permission.
     * <p>
     * For further details, see the definition of
     * {@link com.atom.application.models.UserPermission#name UserPermission.name}
     * <p>
     * Although validation is useless in this case, user permission names are
     * required, should not contain only whitespace and must contain between 5 and
     * 50 valid characters.
     */
    @NotBlank(message = "User permission name is mandatory and cannot contain only whitespace")
    @Size(min = 5, max = 50, message = "User permission name must contain between 5 and 50 valid characters")
    private String name;

    /**
     * The <code>description</code> of a user permission.
     * <p>
     * For further details, see the definition of
     * {@link com.atom.application.models.UserPermission#description
     * UserPermission.description}
     * <p>
     * Although validation is useless in this case, user permission descriptions are
     * required, should not contain only whitespace and must contain between 5 and
     * 255 valid characters.
     */
    @NotBlank(message = "User permission description is mandatory and cannot contain only whitespace")
    @Size(min = 5, max = 255, message = "User permission description must contain between 5 and 255 valid characters")
    private String description;

    /**
     * Retrieves the <code>id</code> of the user permission.
     * <p>
     * See the definition of the {@link #id} field.
     * 
     * @return the <code>id</code> of the permission DTO
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the <code>id</code> of the user permission.
     * <p>
     * See the definition of the {@link #id} field.
     * 
     * @param id - the <code>id</code> of the permission DTO
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the <code>name</code> of the user permission.
     * <p>
     * See the definition of the {@link #name} field.
     * 
     * @return the <code>name</code> of the permission DTO
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the <code>name</code> of the user permission.
     * <p>
     * See the definition of the {@link #name} field.
     * 
     * @param name - the <code>name</code> of the permission DTO
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the <code>description</code> of the user permission.
     * <p>
     * See the definition of the {@link #description} field.
     * 
     * @return the <code>description</code> of the permission DTO
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the <code>description</code> of the user permission.
     * <p>
     * See the definition of the {@link #description} field.
     * 
     * @param description - the <code>description</code> of the permission DTO
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
