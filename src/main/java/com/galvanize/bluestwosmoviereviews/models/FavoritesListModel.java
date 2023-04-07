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

    public Integer getFavoritesID() {
        return favoritesID;
    }

    public void setFavoritesID(Integer favoritesID) {
        this.favoritesID = favoritesID;
    }

    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
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
