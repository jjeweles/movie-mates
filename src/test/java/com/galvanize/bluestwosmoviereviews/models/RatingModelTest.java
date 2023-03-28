package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingModelTest {
    @Test
    void testConstructor() {
        RatingModel ratingModel = new RatingModel(1, 123, 4, null, true, 1);

        assertEquals(1, ratingModel.getRatingId());
        assertEquals(123, ratingModel.getTmdbId());
        assertEquals(4, ratingModel.getStarRating());
        assertNull(ratingModel.getComments());
        assertTrue(ratingModel.isThumbsUpOrDown());
        assertEquals(1, ratingModel.getUserID());
    }
}