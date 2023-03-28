package com.galvanize.bluestwosmoviereviews.models;

public class WatchListModel {

    Integer listId;
    Integer tmdbId;
    Integer userId;

    public WatchListModel() {
    }

    public WatchListModel(Integer listId, Integer tmdbId, Integer userId) {
        this.listId = listId;
        this.tmdbId = tmdbId;
        this.userId = userId;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
