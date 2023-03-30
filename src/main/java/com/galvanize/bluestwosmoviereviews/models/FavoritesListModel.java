package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class FavoritesListModel {
    @Id
    int favListId;
    int  tmdbId;
    int userId;

    public FavoritesListModel() {
    }

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
    @Override
    public int hashCode() {
        return Objects.hash(favListId, tmdbId, userId);
    }

    @Override
    public String toString() {
        return "FavoriteListModel{" +
                "favListId=" + favListId +
                ", tmdbId=" + tmdbId +
                ", userId=" + userId +
                '}';
    }
}
