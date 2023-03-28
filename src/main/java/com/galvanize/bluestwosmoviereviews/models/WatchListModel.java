package com.galvanize.bluestwosmoviereviews.models;

import java.util.Objects;

public class WatchListModel {

    Integer list_id; // Primary key
    Integer tmdb_id;
    Integer user_id; // Foreign key

    public WatchListModel() {
    }

    public WatchListModel(Integer list_id, Integer tmdb_id, Integer user_id) {
        this.list_id = list_id;
        this.tmdb_id = tmdb_id;
        this.user_id = user_id;
    }

    public Integer getList_id() {
        return list_id;
    }

    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }

    public Integer getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(Integer tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
