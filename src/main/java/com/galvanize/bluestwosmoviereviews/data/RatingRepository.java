package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the Rating model
 * @see RatingModel
 * @see JpaRepository
 * @see Repository
 */
@Repository
public interface RatingRepository extends JpaRepository<RatingModel, Integer> {
    List<RatingModel> findByUserID(Integer userId);

    RatingModel findByRatingId(Integer ratingId);

    List<RatingModel> findByTmdbId(Integer tmdbId);
}
