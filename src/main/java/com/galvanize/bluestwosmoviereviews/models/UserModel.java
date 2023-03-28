package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Objects;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    Integer user_id;
    String username;
    String password;
    String email;
    String name;

    public UserModel(Integer user_id, String username, String password, String email, String name) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
        return Objects.hash(user_id, username, password, email, name);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
