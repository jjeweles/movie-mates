package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Represents a rating in the system with basic information such as ratingID, tmdbId, starRating, and userID.
 * <p>
 * This class is annotated with JPA annotations to map it to a database table.
 */
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

    /**
     * Default constructor for the RatingModel class, required by JPA.
     */
    public RatingModel() {
    }

    /**
     * Constructs a new UserModel with the provided username, password, email, and name.
     *
     * @param ratingId the id of the rating
     * @param tmdbId the id of the movie for the rating
     * @param starRating    the rating score given for the rating
     * @param userID     the id of the user giving the rating
     */
    public RatingModel(Integer ratingId, Integer tmdbId, Integer starRating, int userID) {
        this.ratingId = ratingId;
        this.tmdbId = tmdbId;
        this.starRating = starRating;
        this.userID = userID;
    }

    /**
     * Returns the rating ID of the rating.
     *
     * @return the rating ID as an Integer
     */
    public Integer getRatingId() {
        return ratingId;
    }

    /**
     * Sets the rating ID of the rating.
     *
     * @param ratingId for the new ratingId of the rating
     */
    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    /**
     * Returns the tmdb ID of the rating.
     *
     * @return the user ID as an int
     */
    public int getTmdbId() {
        return tmdbId;
    }

    /**
     * Sets the tmdb ID of the rating.
     *
     * @param tmdbId for the new tmbdId of the rating
     */
    public void setTmdbId(int tmdbId) {
        this.tmdbId = tmdbId;
    }

    /**
     * Returns the user starRating of the rating.
     *
     * @return the user ID as an int
     */
    public int getStarRating() {
        return starRating;
    }

    /**
     * Sets the starRating ID of the rating.
     *
     * @param starRating for the new starRating of the rating
     */
    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    /**
     * Returns the user ID of the rating.
     *
     * @return the user ID as an int
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the user ID of the rating.
     *
     * @param userId for the new userId of the rating
     */
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
