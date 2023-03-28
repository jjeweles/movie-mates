package com.galvanize.bluestwosmoviereviews.models;

public class HistoryModel {

    Integer historyId;
    Integer tmdbId;
    Integer userId;

    public HistoryModel(){
    }

    public HistoryModel(Integer history_id, Integer tmdb_id, Integer user_id) {
        this.historyId = history_id;
        this.tmdbId = tmdb_id;
        this.userId = user_id;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public int getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
