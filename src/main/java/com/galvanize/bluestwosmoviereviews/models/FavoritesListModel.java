package com.galvanize.bluestwosmoviereviews.models;

public class FavoritesListModel {
    int favListId;
    int  tmdbId;
    int userId;

    public FavoritesListModel(int favListID, int tmdbId, int userID)
    {
        this.favListId = favListID;
        this.tmdbId = tmdbId;
        this.userId = userID;
    }
    public int getFavListId() {
        return favListId;
    }

    public void setFavListId(int favListId) {
        this.favListId = favListId;
    }

    public int getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
