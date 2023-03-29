package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

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
            existingRating.get().setUserId(rating.getUserId());
            return ratingRepository.save(existingRating.get());
        }
        return null;
    }

    public List<RatingModel> getAllRatingsByUserId(Integer userId) {
        return ratingRepository.findByUserId(userId);
    }

    public void deleteById(Integer ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public RatingModel addNewRating(RatingModel ratingModel) {
        return ratingRepository.save(ratingModel);
    }
}
