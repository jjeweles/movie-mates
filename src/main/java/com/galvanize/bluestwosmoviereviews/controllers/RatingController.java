package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RatingController {

    RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("rating/get")
    public ResponseEntity<List<RatingModel>> getAllRatings() {

        List<RatingModel> ratings = ratingService.getAllRatings();
        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    @GetMapping("rating/getUserRatings/{userId}")
    public ResponseEntity<List<RatingModel>> getAllRatingsByUserId(@PathVariable Integer userId) {

        List<RatingModel> ratings = ratingService.getAllRatingsByUserId(userId);
        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    @GetMapping("rating/getRatingsForMovie/{tmdbId}")
    public ResponseEntity<List<RatingModel>> getMovieRatingByIdmbId(@PathVariable Integer tmdbId) {

        List<RatingModel> listOfRatingsForMovie = ratingService.getAllRatingsByTmdbId(tmdbId);
        return listOfRatingsForMovie == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(listOfRatingsForMovie);
    }

    @GetMapping("rating/getMovieAvgMovieRating/{tmdbId}")
    public ResponseEntity<Double> getAvgMovieRating(@PathVariable Integer tmdbId) {

        Double averageRating = ratingService.getAverageMovieRating(tmdbId);
        return averageRating == 0 ? ResponseEntity.noContent().build()  : ResponseEntity.ok(averageRating);
    }

    @PutMapping("rating/update/{ratingId}")
    public ResponseEntity<RatingModel> updateRating(@PathVariable Integer ratingId,
                                                    @RequestBody RatingModel ratingModel) {

        RatingModel updateRating = ratingService.updateRating(ratingId, ratingModel);
        return new ResponseEntity<>(updateRating, HttpStatus.OK);
    }

    @PostMapping("rating/save")
    public ResponseEntity<RatingModel> addNewRating(@RequestBody RatingModel ratingModel) {

        RatingModel newRating = ratingService.addNewRating(ratingModel);
        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }

    @DeleteMapping("rating/delete/{ratingId}")
    public ResponseEntity<RatingModel> deleteRating(@PathVariable Integer ratingId) {

        RatingModel deleteRating = ratingService.deleteById(ratingId);
        return deleteRating == null ? ResponseEntity.noContent().build() : ResponseEntity.accepted().build();
    }
}
