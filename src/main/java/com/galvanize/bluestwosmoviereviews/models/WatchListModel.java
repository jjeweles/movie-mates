package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "watchlist")
public class WatchListModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    Integer id;

    @Column(name = "userID")
    Integer userID;

    @Column(unique = true, name = "tmdbId")
    Integer tmdbId;

    public WatchListModel() {
    }

    public WatchListModel(Integer userID, Integer tmdbId) {
        this.tmdbId = tmdbId;
        this.id = userID;
    }

    public Integer getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchListModel that = (WatchListModel) o;
        return Objects.equals(id, that.id) && Objects.equals(userID, that.userID) && Objects.equals(tmdbId, that.tmdbId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userID, tmdbId);
    }

    @Override
    public String toString() {
        return "WatchListModel{" +
                "id=" + id +
                ", userId=" + userID +
                ", tmdbId=" + tmdbId +
                '}';
    }
}
