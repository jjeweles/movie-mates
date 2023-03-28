package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    RatingService ratingService;
    RatingModel ratingModel;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/api/v1/rating/get")
    public ResponseEntity<RatingModel> getRating() {
        RatingModel ratings = ratingService.getAllRatings();

        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok().build();
    }

}

