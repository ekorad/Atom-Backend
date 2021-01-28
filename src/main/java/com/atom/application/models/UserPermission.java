package com.atom.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Entity representation of user permissions.</b>
 * <p>
 * User permissions determine to what degree can the user interact with the
 * internal database and its contents.
 * <p>
 * In simpler terms, permissions determine whether the user can, for example,
 * delete the comment of another user, or edit the account of another user.
 */
@Entity
@Table(name = "user_permissions")
public class UserPermission {

    /**
     * <b>Primary key of the table.</b>
     * <p>
     * Used as a unique identifier for the permission.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * <b>The name of the permission.</b>
     * <p>
     * It is also used as a unique identifier for the permission.
     */
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    /**
     * <b>The description of the permission</b>
     * <p>
     * The description points out what privilege does the permission bring to the
     * user.
     * <p>
     * The description should also be unique, but for performance reasons it is not
     * implemented using the <code>unique</code> attribute.
     */
    @Column(nullable = false)
    private String description;

    /**
     * Retrieves the <code>id</code> of the permission.
     * <p>
     * See the definition of the {@link #id} field.
     * 
     * @return the <code>id</code> of the permission entity
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the <code>id</code> of the permission.
     * <p>
     * See the definition of the {@link #id} field.
     * 
     * @param id - the <code>id</code> of the permission entity
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the <code>name</code> of the permission.
     * <p>
     * See the definition of the {@link #name} field.
     * 
     * @return the <code>name</code> of the permission entity
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the <code>name</code> of the permission.
     * <p>
     * See the definition of the {@link #name} field.
     * 
     * @param name - the <code>name</code> of the permission entity
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the <code>description</code> of the permission.
     * <p>
     * See the definition of the {@link #description} field.
     * 
     * @return the <code>description</code> of the permission entity
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the <code>description</code> of the permission.
     * <p>
     * See the definition of the {@link #description} field.
     * 
     * @param description - the <code>description</code> of the permission entity
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
