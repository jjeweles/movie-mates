package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing rating operations.
 * <p>
 * The {@code RatingController} class handles HTTP requests for operations such as
 * creating, updating, retrieving, and deleting ratings.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class RatingController {

    private final RatingService ratingService;

    /** Constructs a new {@code RatingController} with the specified {@code UserService}.
     *
     * @param ratingService the user service used to perform rating-related operations
     */

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    /**
     * Retrieves all ratings.
     *
     * @return an {@code List} containing all {@code RatingModel} instances
     */

    @GetMapping("rating/get")
    public ResponseEntity<List<RatingModel>> getAllRatings() {

        List<RatingModel> ratings = ratingService.getAllRatings();
        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    /**
     * Retrieves a rating by their userID.
     *
     * @param userId the ID of the user to retrieve ratings by
     * @return a {@code List} containing the requested {@code RatingModel} instances if found,
     *         or an empty {@code ResponseEntity} with a no-content status if not found
     */

    @GetMapping("rating/getUserRatings/{userId}")
    public ResponseEntity<List<RatingModel>> getAllRatingsByUserId(@PathVariable Integer userId) {
        List<RatingModel> ratings = ratingService.getAllRatingsByUserId(userId);
        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    /**
     * Retrieves a rating by their userID.
     *
     * @param tmdbId the ID of the movie to retrieve ratings by
     * @return a {@code List} containing the requested {@code RatingModel} instances if found,
     *         or an empty {@code ResponseEntity} with a no-content status if not found
     */

    @GetMapping("rating/getRatingsForMovie/{tmdbId}")
    public ResponseEntity<List<RatingModel>> getMovieRatingByIdmbId(@PathVariable Integer tmdbId) {
        List<RatingModel> listOfRatingsForMovie = ratingService.getAllRatingsByTmdbId(tmdbId);
        return listOfRatingsForMovie == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(listOfRatingsForMovie);
    }

    /**
     * Retrieves a rating by their userID.
     *
     * @param tmdbId the ID of the movie to retrieve ratings by
     * @return a {@code ResponseEntity} containing the average rating of the movies {@code Double} if found,
     *      *         or an empty {@code ResponseEntity} with a no-content status if not found
     */

    @GetMapping("rating/getMovieAvgMovieRating/{tmdbId}")
    public ResponseEntity<Double> getAvgMovieRating(@PathVariable Integer tmdbId) {
        Double averageRating = ratingService.getAverageMovieRating(tmdbId);
        return averageRating == 0 ? ResponseEntity.noContent().build() : ResponseEntity.ok(averageRating);
    }

    /**
     * Updates an existing user.
     *
     * @param ratingId the ID of the rating to update
     * @param ratingModel the {@code RatingModel} instance containing the updated data
     * @return the updated {@code RatingModel} instance
     */

    @PutMapping("rating/update/{ratingId}")
    public ResponseEntity<RatingModel> updateRating(@PathVariable Integer ratingId, @RequestBody RatingModel ratingModel) {
        RatingModel updateRating = ratingService.updateRating(ratingId, ratingModel);
        return new ResponseEntity<>(updateRating, HttpStatus.OK);
    }

    /**
     * Creates a new rating.
     *
     * @param ratingModel the {@code RatingModel} instance to create
     * @return the created {@code RatingModel} instance
     */

    @PostMapping("rating/save")
    public ResponseEntity<RatingModel> addNewRating(@RequestBody RatingModel ratingModel) {
        RatingModel newRating = ratingService.addNewRating(ratingModel);
        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param ratingId the ID of the rating to delete
     * @return a {@code ResponseEntity} containing the deleted {@code RatingModel} instance if found,
     *         or an empty {@code ResponseEntity} with a no-content status if not found
     */

    @DeleteMapping("rating/delete/{ratingId}")
    public ResponseEntity<RatingModel> deleteRating(@PathVariable Integer ratingId) {
        RatingModel deleteRating = ratingService.deleteById(ratingId);
        return deleteRating == null ? ResponseEntity.noContent().build() : ResponseEntity.accepted().build();
    }
}