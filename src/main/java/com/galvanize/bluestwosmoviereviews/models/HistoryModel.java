package com.galvanize.bluestwosmoviereviews.models;

public class HistoryModel {

    Integer history_id;
    Integer tmdb_id;
    Integer user_id;

    public HistoryModel(){
    }

    public HistoryModel(Integer history_id, Integer tmdb_id, Integer user_id) {
        this.history_id = history_id;
        this.tmdb_id = tmdb_id;
        this.user_id = user_id;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(Integer history_id) {
        this.history_id = history_id;
    }

    public int getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(Integer tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

}
