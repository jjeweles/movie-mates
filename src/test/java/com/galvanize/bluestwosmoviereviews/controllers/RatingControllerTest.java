package com.galvanize.bluestwosmoviereviews.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.RatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        rating1 = new RatingModel(1, 123, 5, null, true, 1);
        rating2 = new RatingModel(2, 456, 4, null, false, 2);
        ratingList = new ArrayList<>();
        ratingList.add(rating1);
        ratingList.add(rating2);
    }

    @Test
    void testGetAllRatings() throws Exception {
        when(ratingService.getAllRatings()).thenReturn(ratingList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/rating/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(ratingList.size()))
                .andExpect(jsonPath("$[0].ratingId").value(rating1.getRatingId()))
                .andExpect(jsonPath("$[0].tmdbId").value(rating1.getTmdbId()))
                .andExpect(jsonPath("$[0].starRating").value(rating1.getStarRating()))
                .andExpect(jsonPath("$[0].comments").value(rating1.getComments()))
                .andExpect(jsonPath("$[0].thumbsUpOrDown").value(rating1.isThumbsUpOrDown()))
                .andExpect(jsonPath("$[0].userID").value(rating1.getUserId()))
                .andExpect(jsonPath("$[1].ratingId").value(rating2.getRatingId()))
                .andExpect(jsonPath("$[1].tmdbId").value(rating2.getTmdbId()))
                .andExpect(jsonPath("$[1].starRating").value(rating2.getStarRating()))
                .andExpect(jsonPath("$[1].comments").value(rating2.getComments()))
                .andExpect(jsonPath("$[1].thumbsUpOrDown").value(rating2.isThumbsUpOrDown()))
                .andExpect(jsonPath("$[1].userID").value(rating2.getUserId()));
    }

    @Test
    void testUpdateRatingById() throws Exception {
        when(ratingService.updateRating(anyInt(), any(RatingModel.class))).thenReturn(rating1);

        mockMvc.perform(patch("/api/v1/rating/update/" + rating1.getRatingId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"star_rating\": \"3\", \"comment\": \"This movie rocks\", \"thumbsUpOrDown\": \"false\", \"userID\": \"1\"}"))
                .andDo(print())

                .andExpect(status().isOk())
                .andExpect(jsonPath("ratingId").value(rating1.getRatingId()))
                .andExpect(jsonPath("tmdbId").value(rating1.getTmdbId()))
                .andExpect(jsonPath("starRating").value(rating1.getStarRating()))
                .andExpect(jsonPath("comments").value(rating1.getComments()))
                .andExpect(jsonPath("thumbsUpOrDown").value(rating1.isThumbsUpOrDown()))
                .andExpect(jsonPath("userID").value(rating1.getUserId()));
    }

    @Test
    void testAddRating() throws Exception {
        when(ratingService.addNewRating(any(RatingModel.class))).thenReturn(rating1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/rating/save")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(rating1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("tmdbId").value(123));
    }
}

