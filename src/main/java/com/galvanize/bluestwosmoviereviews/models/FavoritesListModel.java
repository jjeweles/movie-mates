package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favorites")
public class FavoritesListModel {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer favoritesID;
    @Column(name = "tmdbID")
    private Integer tmdbId;
    @Column(name = "userID")
    private Integer userID;

    public FavoritesListModel() {
    }

    public FavoritesListModel(int tmdbId, int userID) {
        this.tmdbId = tmdbId;
        this.userID = userID;
    }

    public int getFavoritesID() {
        return favoritesID;
    }

    public void setFavoritesID(int favListId) {
        this.favoritesID = favListId;
    }

    public int getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoritesID, tmdbId, userID);
    }

    @Override
    public String toString() {
        return "FavoriteListModel{" +
                ", tmdbId=" + tmdbId +
                ", userID=" + userID +
                '}';
    }
}
