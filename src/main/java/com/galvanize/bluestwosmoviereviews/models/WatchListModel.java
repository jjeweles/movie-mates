package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "watchlist")
public class WatchListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlistID")
    Integer watchlistID;

    @Column(name = "userID")
    Integer userID;

    @Column(name = "tmdbID")
    Integer tmdbID;

    public WatchListModel() {
    }

    public WatchListModel(Integer userID, Integer tmdbID) {
        this.tmdbID = tmdbID;
        this.userID = userID;
    }

    public Integer getTmdbID() {
        return tmdbID;
    }

    public void setTmdbID(Integer tmdbId) {
        this.tmdbID = tmdbId;
    }

    public Integer getWatchlistID() {
        return watchlistID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchListModel that = (WatchListModel) o;
        return Objects.equals(watchlistID, that.watchlistID) && Objects.equals(userID, that.userID) && Objects.equals(tmdbID, that.tmdbID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchlistID, userID, tmdbID);
    }

    @Override
    public String toString() {
        return "WatchListModel{" +
                "id=" + watchlistID +
                ", userID=" + userID +
                ", tmdb_id=" + tmdbID +
                '}';
    }
}
