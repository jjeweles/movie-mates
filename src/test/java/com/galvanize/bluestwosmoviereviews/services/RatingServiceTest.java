package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

    @Mock
    RatingRepository ratingRepository;

    RatingService ratingService;

    @BeforeEach
    void setup() {
        ratingService = new RatingService(ratingRepository);
    }

    @Test
    public void testGetAllRatings() {
        List<RatingModel> ratings = new ArrayList<>();
        ratings.add(new RatingModel(1, 1234, 5, 1));
        ratings.add(new RatingModel(2, 5678, 4, 2));

        when(ratingRepository.findAll()).thenReturn(ratings);

        List<RatingModel> result = ratingService.getAllRatings();

        assertEquals(2, result.size());
        assertEquals(ratings, result);
    }

    @Test
    public void testUpdateRatingReturnsRatingOrNull() {
        RatingModel rating1 = new RatingModel(1, 123, 5, 1);
        RatingModel rating2 = new RatingModel(1, 123, 3, 1);

        when(ratingRepository.findById(anyInt()))
                .thenReturn(Optional.of(rating1));
        when(ratingRepository.save(any(RatingModel.class))).thenReturn(rating1);

        RatingModel rate = ratingService.updateRating(1, rating2);
        assertThat(rate).isNotNull();
        assertThat(rate.getStarRating()).isEqualTo(3);
//        assertFalse(rate.isThumbsUpOrDown());
    }

    @Test
    public void testGetAllRatingsByUserIdReturnsAllRatings() {
        int userId = 123;

        List<RatingModel> ratings = new ArrayList<>();
        ratings.add(new RatingModel(1, 1234, 5, userId));
        ratings.add(new RatingModel(2, 5678, 4, userId));

        when(ratingRepository.findByUserID(userId)).thenReturn(ratings);

        List<RatingModel> result = ratingService.getAllRatingsByUserId(userId);

        assertEquals(result, ratings);
    }

    @Test
    public void testGetAllRatingsByTmdbIdReturnsAllRatings() {
        int tmdbId = 4;

        List<RatingModel> ratings = new ArrayList<>();
        ratings.add(new RatingModel(1, tmdbId, 5, 1));
        ratings.add(new RatingModel(2, tmdbId, 4, 1));

        when(ratingRepository.findByTmdbId(tmdbId)).thenReturn(ratings);

        List<RatingModel> result = ratingService.getAllRatingsByTmdbId(tmdbId);

        assertEquals(result, ratings);
    }

    @Test
    public void testAddRatingReturnsRating() {

        RatingModel rating1 = new RatingModel(232, 123, 5, 1);

        when(ratingRepository.save(any(RatingModel.class))).thenReturn(rating1);

        RatingModel rating = ratingService.addNewRating(rating1);

        assertThat(rating).isNotNull();
        assertThat(rating.getRatingId()).isEqualTo(232);
    }

    @Test
    public void deleteRatingReturnsRating() {
        RatingModel rating1 = new RatingModel(232, 123, 5, 1);

        when(ratingRepository.findByRatingId(anyInt())).thenReturn(rating1);

        RatingModel rating = ratingService.deleteById(232);
        assertThat(rating).isNotNull();
        assertThat(rating.getRatingId()).isEqualTo(232);
    }
}