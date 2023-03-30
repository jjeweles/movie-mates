package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "watchlist")
public class WatchListModel {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true, name = "tmdbId")
    Integer tmdbId;

    public WatchListModel() {
    }

    public WatchListModel(Integer tmdbId) {
        this.tmdbId = tmdbId;
    }


    public WatchListModel(Integer userId, Integer tmdbId) {
        this.tmdbId = tmdbId;
        this.id = userId;
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
    public int hashCode() {
        return Objects.hash(id, tmdbId);
    }

    @Override
    public String toString() {
        return "WatchListModel{" +
                "userId=" + id +
                ", tmdbId=" + tmdbId +
                '}';
    }

}
