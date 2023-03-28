package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RatingController.class)
class RatingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RatingService ratingService;

    RatingModel rating1;
    RatingModel rating2;
    List<RatingModel> ratingList;

    @Test
    void testGetAllRatings() throws Exception {

        rating1 = new RatingModel(1, 123, 5, null, true, 1);
        rating2 = new RatingModel(2, 456, 4, null, false, 2);
        ratingList = new ArrayList<>();
        ratingList.add(rating1);
        ratingList.add(rating2);

        when(ratingService.getAllRatings()).thenReturn(ratingList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/rating/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(ratingList.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ratingId").value(rating1.getRatingId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].tmdbId").value(rating1.getTmdbId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].starRating").value(rating1.getStarRating()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].comments").value(rating1.getComments()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].thumbsUpOrDown").value(rating1.isThumbsUpOrDown()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userID").value(rating1.getUserID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ratingId").value(rating2.getRatingId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].tmdbId").value(rating2.getTmdbId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].starRating").value(rating2.getStarRating()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].comments").value(rating2.getComments()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].thumbsUpOrDown").value(rating2.isThumbsUpOrDown()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userID").value(rating2.getUserID()));
    }
}

