package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.models.UserModel;

public class RatingService {

    RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public RatingModel getRating(Integer tdmb_id) {
        return ratingRepository.findByTdmb()
    }


    public UserModel getUserByID(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}
