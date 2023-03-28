package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
