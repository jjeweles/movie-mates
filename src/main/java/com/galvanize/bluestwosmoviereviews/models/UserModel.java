package com.galvanize.bluestwosmoviereviews.models;

import java.util.HashMap;
import java.util.Objects;

public class UserModel {

    Integer user_id;
    String username;
    String password;
    String email;
    String name;
    HashMap<Integer, Integer> watch_list;
    HashMap<Integer, Integer> fav_list;
    HashMap<Integer, Integer> history;
    HashMap<Integer, Integer> user_ratings;

    public UserModel() {
    }

    public UserModel(Integer user_id, String username, String password, String email, String name, HashMap<Integer, Integer> watch_list, HashMap<Integer, Integer> fav_list, HashMap<Integer, Integer> history, HashMap<Integer, Integer> user_ratings) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.watch_list = watch_list;
        this.fav_list = fav_list;
        this.history = history;
        this.user_ratings = user_ratings;
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

    public HashMap<Integer, Integer> getWatch_list() {
        return watch_list;
    }

    public void setWatch_list(HashMap<Integer, Integer> watch_list) {
        this.watch_list = watch_list;
    }

    public HashMap<Integer, Integer> getFav_list() {
        return fav_list;
    }

    public void setFav_list(HashMap<Integer, Integer> fav_list) {
        this.fav_list = fav_list;
    }

    public HashMap<Integer, Integer> getHistory() {
        return history;
    }

    public void setHistory(HashMap<Integer, Integer> history) {
        this.history = history;
    }

    public HashMap<Integer, Integer> getUser_ratings() {
        return user_ratings;
    }

    public void setUser_ratings(HashMap<Integer, Integer> user_ratings) {
        this.user_ratings = user_ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(user_id, userModel.user_id) && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password) && Objects.equals(email, userModel.email) && Objects.equals(name, userModel.name) && Objects.equals(watch_list, userModel.watch_list) && Objects.equals(fav_list, userModel.fav_list) && Objects.equals(history, userModel.history) && Objects.equals(user_ratings, userModel.user_ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, email, name, watch_list, fav_list, history, user_ratings);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", watch_list=" + watch_list +
                ", fav_list=" + fav_list +
                ", history=" + history +
                ", user_ratings=" + user_ratings +
                '}';
    }
}
