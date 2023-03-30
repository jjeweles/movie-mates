package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "watchlist")
public class WatchListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer watchlistID;

    @Column(name = "userID")
    Integer userID;

    @Column(unique = true, name = "tmdbId")
    Integer tmdbId;

    public WatchListModel() {
    }

    public WatchListModel(Integer userID, Integer tmdbId) {
        this.tmdbId = tmdbId;
        this.userID = userID;
    }

    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    public Integer getWatchlistID() {
        return watchlistID;
    }

    public void setWatchlistID(Integer id) {
        this.watchlistID = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchListModel that = (WatchListModel) o;
        return Objects.equals(watchlistID, that.watchlistID) && Objects.equals(userID, that.userID) && Objects.equals(tmdbId, that.tmdbId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchlistID, userID, tmdbId);
    }

    @Override
    public String toString() {
        return "WatchListModel{" +
                "id=" + watchlistID +
                ", userId=" + userID +
                ", tmdbId=" + tmdbId +
                '}';
    }
}
