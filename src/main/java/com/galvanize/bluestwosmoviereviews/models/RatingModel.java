package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ratings")
public class RatingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer ratingId;

    @Column(name = "tmdb_id")
    private Integer tmdbId;

    @Column(name = "star_rating")
    private Integer starRating;

    @Column(name = "userID")
    private int userID;

    public RatingModel(Integer ratingId, Integer tmdbId, Integer starRating, int userID) {
        this.ratingId = ratingId;
        this.tmdbId = tmdbId;
        this.starRating = starRating;
        this.userID = userID;
    }

    public RatingModel() {
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public int getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userId) {
        this.userID = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingModel that = (RatingModel) o;
        return userID == that.userID && Objects.equals(ratingId, that.ratingId) && Objects.equals(tmdbId, that.tmdbId) && Objects.equals(starRating, that.starRating);
        // removed: "thumbsUpOrDown == that.thumbsUpOrDown &&" just before userID in return until thumsUpOrDown working
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, tmdbId, starRating, userID);
        // removed thumsUpOrDown until working
    }

    @Override
    public String toString() {
        return "RatingModel{" +
                "ratingId=" + ratingId +
                ", tmdbId=" + tmdbId +
                ", starRating=" + starRating +
//                ", thumbsUpOrDown=" + thumbsUpOrDown +
                '}';
    }
}
