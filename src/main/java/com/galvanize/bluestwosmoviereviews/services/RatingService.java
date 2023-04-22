package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Provides user-related services using a {@code RatingRepository}.
 * <p>
 * The {@code RatingService} class handles operations such as creating, updating, retrieving, and
 * deleting ratings using a {@code RatingRepository} instance.
 */
@Service
public class RatingService {

    private RatingRepository ratingRepository;

    /**
     * Constructs a new {@code RatingService} with the specified {@code RatingRepository}.
     *
     * @param ratingRepository the repository used to perform rating-related operations
     */
    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    /**
     * Retrieves all ratings.
     *
     * @return an {@code List} containing all {@code RatingModel} instances
     */
    public List<RatingModel> getAllRatings() {
        return ratingRepository.findAll();
    }

    /**
     * Updates an existing rating.
     *
     * @param ratingID   the ID of the rating to update
     * @param rating the {@code RatingModel} instance containing the updated data
     * @return the updated {@code RatingModel} instance
     */
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

    /**
     * Retrieves ratings by their ID.
     *
     * @param userId the ID of the user to retrieve
     * @return a {@code List} containing all {@code RatingModel} instances with the specified ID, or {@code null} if not found
     */
    public List<RatingModel> getAllRatingsByUserId(Integer userId) {
        return ratingRepository.findByUserID(userId);
    }

    /**
     * Deletes a rating by their ID.
     *
     * @param ratingId the ID of the rating to delete
     * @return the deleted {@code RatingModel} instance
     */
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

    /**
     * Retrieves ratings by their ID.
     *
     * @param tmdbId the ID of the user to retrieve
     * @return a {@code List} containing all {@code RatingModel} instances with the specified ID
     */
    public List<RatingModel> getAllRatingsByTmdbId(Integer tmdbId) {
        return ratingRepository.findByTmdbId(tmdbId);
    }

    /**
     * Retrieves ratings by their ID.
     *
     * @param tmdbId the ID of the user to retrieve
     * @return a {@code Double} average of all rating scores of {@code RatingModel} instances with the specified ID
     */
    public Double getAverageMovieRating(Integer tmdbId) {
        List<RatingModel> listOfRatings = ratingRepository.findByTmdbId(tmdbId);
        double averageRating = 0;

        for (RatingModel movieRating : listOfRatings) {
            averageRating += movieRating.getStarRating();
        }
        averageRating = averageRating / listOfRatings.size();
        return Double.parseDouble(String.format("%.1f", averageRating));
    }
}
