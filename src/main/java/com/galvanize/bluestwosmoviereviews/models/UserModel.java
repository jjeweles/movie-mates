package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    Integer userID;
    @Column(unique = true, name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;
    @Column(name = "name")
    String name;

    public UserModel() {
    }

    public UserModel(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

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
