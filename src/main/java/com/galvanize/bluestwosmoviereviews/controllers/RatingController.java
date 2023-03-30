package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/api/v1/rating/get")
    public ResponseEntity<List<RatingModel>> getAllRatings() {
        List<RatingModel> ratings = ratingService.getAllRatings();

        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    @GetMapping("/api/v1/rating/getUserRatings/{userId}")
    public ResponseEntity<List<RatingModel>> getAllRatingsByUserId(@PathVariable Integer userId) {
        List<RatingModel> ratings = ratingService.getAllRatingsByUserId(userId);

        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    @PutMapping("/api/v1/rating/update/{ratingId}")
    public ResponseEntity<RatingModel> updateRating(@PathVariable Integer ratingId,
                                                    @RequestBody RatingModel ratingModel) {

        RatingModel updateRating = ratingService.updateRating(ratingId, ratingModel);
        return new ResponseEntity<>(updateRating, HttpStatus.OK);
    }

    @PostMapping("/api/v1/rating/save")
    public ResponseEntity<RatingModel> addNewRating(@RequestBody RatingModel ratingModel) {

        RatingModel newRating = ratingService.addNewRating(ratingModel);
        return new ResponseEntity<>(newRating, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/v1/rating/delete/{ratingId}")
    public ResponseEntity<RatingModel> deleteRating(@PathVariable Integer ratingId) {

        RatingModel deleteRating = ratingService.deleteById(ratingId);
        return deleteRating == null ? ResponseEntity.noContent().build() : ResponseEntity.accepted().build();
    }
}
