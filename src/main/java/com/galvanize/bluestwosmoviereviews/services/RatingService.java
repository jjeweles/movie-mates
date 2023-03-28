package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<RatingModel> getAllRatings() {
        return ratingRepository.findAll();
    }

    public RatingModel updateRating(Integer ratingID, RatingModel rating) {
        Optional<RatingModel> existingRating = ratingRepository.findById(ratingID);
        if (existingRating.isPresent()) {
            existingRating.get().setTmdbId(rating.getTmdbId());
            existingRating.get().setStarRating(rating.getStarRating());
            existingRating.get().setComments(rating.getComments());
            existingRating.get().setThumbsUpOrDown(rating.isThumbsUpOrDown());
            existingRating.get().setUserID(rating.getUserID());
            return ratingRepository.save(existingRating.get());
        }
        return null;
    }
}
