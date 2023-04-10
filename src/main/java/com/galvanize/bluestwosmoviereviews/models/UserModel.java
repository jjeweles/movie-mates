package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Represents a user in the system with basic information such as username, password, email, and name.
 * <p>
 * This class is annotated with JPA annotations to map it to a database table.
 */
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer userID;
    @Column(unique = true, name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;

    /**
     * Default constructor for the UserModel class, required by JPA.
     */
    public UserModel() {
    }

    /**
     * Constructs a new UserModel with the provided username, password, email, and name.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param email    the email address of the user
     * @param name     the name of the user
     */
    public UserModel(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    /**
     * Returns the user ID of the user.
     *
     * @return the user ID as an Integer
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID of the user.
     *
     * @param userID for the new userID of the user
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username as a String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username for the new username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password as a String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password for the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email address of the user.
     *
     * @return the email address as a String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email for the new email address of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name for the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, password, email, name);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
