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

    @PatchMapping("/api/v1/rating/update/{ratingId}")
    public ResponseEntity<RatingModel> updateRating(@PathVariable Integer ratingId,
                                                    @RequestBody RatingModel ratingModel) {

        RatingModel updateRating = ratingService.updateRating(ratingId, ratingModel);
        return new ResponseEntity<>(updateRating, HttpStatus.OK);
    }
}
