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
//            existingRating.get().setThumbsUpOrDown(rating.isThumbsUpOrDown());
            existingRating.get().setUserID(rating.getUserID());
            return ratingRepository.save(existingRating.get());
        }
        return null;
    }

    public List<RatingModel> getAllRatingsByUserId(Integer userId) {
        return ratingRepository.findByUserID(userId);
    }

    public RatingModel deleteById(Integer ratingId) {
        RatingModel ratingToDelete = ratingRepository.findByRatingId(ratingId);

        if (ratingToDelete != null) {
            ratingRepository.delete(ratingToDelete);
        }

        return ratingToDelete;
    }

    public RatingModel addNewRating(RatingModel ratingModel) {
        return ratingRepository.save(ratingModel);
    }

    public List<RatingModel> getAllRatingsByTmdbId(Integer tmdbId) {
        return ratingRepository.findByTmdbId(tmdbId);
    }
}
