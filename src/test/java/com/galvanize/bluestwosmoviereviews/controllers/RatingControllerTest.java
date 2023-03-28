package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class RatingControllerTest {

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    @Test
    public void testGetAllRatings() {
        List<RatingModel> ratings = new ArrayList<>();
        ratings.add(new RatingModel(1, 1234, 5, null, true, 1));
        ratings.add(new RatingModel(2, 5678, 4, null, false, 2));

        Mockito.when(ratingService.getAllRatings()).thenReturn(ratings);

        ResponseEntity<List<RatingModel>> response = ratingController.getAllRatings();

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        Assert.assertEquals(ratings, response.getBody());
    }

}