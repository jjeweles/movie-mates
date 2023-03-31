package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingModelTest {
    RatingModel rating;

    @Test
    void testRatingConstructor() {
        rating = new RatingModel(1, 123, 5, true, 1);
        assertEquals(1, rating.getRatingId());
        assertEquals(123, rating.getTmdbId());
        assertEquals(5, rating.getStarRating());
//        assertTrue(rating.isThumbsUpOrDown());
        assertEquals(1, rating.getUserID());
    }
}