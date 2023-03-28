package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.RatingRepository;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        ratings.add(new RatingModel(1, 1234, 5, null, true, 1));
        ratings.add(new RatingModel(2, 5678, 4, null, false, 2));

        when(ratingRepository.findAll()).thenReturn(ratings);

        List<RatingModel> result = ratingService.getAllRatings();

        assertEquals(2, result.size());
        assertEquals(ratings, result);
    }
}