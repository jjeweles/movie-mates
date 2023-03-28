package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.models.UserModel;

import java.util.List;

public class RatingService {

    RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

//    public RatingModel getRating(Integer tdmb_id) {
//        List<RatingModel> ratings;
//        return ratings;
//    }
//
//
//    public UserModel getUserByID(Integer id) {
//        return userRepository.findById(id).orElse(null);
//    }

}
