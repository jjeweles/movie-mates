package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Objects;

@Entity
@Table(name = "User_Rating")
public class RatingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Integer ratingId;

    @Column(name = "tmdb_id")
    private Integer tmdbId;

    @Column(name = "Star_rating")
    private Integer starRating;
    private HashMap<Integer, String> comments;

    @Column(name = "Thumbs_up_or_down")
    private boolean thumbsUpOrDown;

    @Column(name = "user_id")
    private int userId;

    public RatingModel(Integer ratingId, Integer tmdbId, Integer starRating, HashMap<Integer, String> comments, boolean thumbsUpOrDown, int userId) {
        this.ratingId = ratingId;
        this.tmdbId = tmdbId;
        this.starRating = starRating;
        this.comments = comments;
        this.thumbsUpOrDown = thumbsUpOrDown;
        this.userId = userId;
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

    public HashMap<Integer, String> getComments() {
        return comments;
    }

    public void setComments(HashMap<Integer, String> comments) {
        this.comments = comments;
    }

    public boolean isThumbsUpOrDown() {
        return thumbsUpOrDown;
    }

    public void setThumbsUpOrDown(boolean thumbsUpOrDown) {
        this.thumbsUpOrDown = thumbsUpOrDown;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.galvanize.bluestwosmoviereviews.models.RatingModel that = (com.galvanize.bluestwosmoviereviews.models.RatingModel) o;
        return thumbsUpOrDown == that.thumbsUpOrDown && userId == that.userId && Objects.equals(ratingId, that.ratingId) && Objects.equals(tmdbId, that.tmdbId) && Objects.equals(starRating, that.starRating) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ratingId, tmdbId, starRating, comments, thumbsUpOrDown, userId);
    }

    @Override
    public String toString() {
        return "RatingModel{" +
                "ratingId=" + ratingId +
                ", tmdbId=" + tmdbId +
                ", starRating=" + starRating +
                ", comments=" + comments +
                ", thumbsUpOrDown=" + thumbsUpOrDown +
                '}';
    }
}
