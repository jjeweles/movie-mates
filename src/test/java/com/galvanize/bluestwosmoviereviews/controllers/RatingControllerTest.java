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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
                .andExpect(jsonPath("$[0].userId").value(rating1.getUserID()))
                .andExpect(jsonPath("$[1].ratingId").value(rating2.getRatingId()))
                .andExpect(jsonPath("$[1].tmdbId").value(rating2.getTmdbId()))
                .andExpect(jsonPath("$[1].starRating").value(rating2.getStarRating()))
                .andExpect(jsonPath("$[1].comments").value(rating2.getComments()))
                .andExpect(jsonPath("$[1].thumbsUpOrDown").value(rating2.isThumbsUpOrDown()))
                .andExpect(jsonPath("$[1].userId").value(rating2.getUserID()));
    }

    @Test
    void testGetAllRatingsById() throws Exception {
        rating1 = new RatingModel(1, 123, 5, null, true, 2);
        rating2 = new RatingModel(2, 456, 4, null, false, 1);

        when(ratingService.getAllRatingsByUserId(anyInt())).thenReturn(ratingList);

        mockMvc.perform(get("/api/v1/rating/getUserRatings/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(1));
    }

    @Test
    void testUpdateRatingById() throws Exception {
        when(ratingService.updateRating(anyInt(), any(RatingModel.class))).thenReturn(rating1);

        mockMvc.perform(put("/api/v1/rating/update/" + rating1.getRatingId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"star_rating\": \"3\", \"thumbsUpOrDown\": \"false\", \"userID\": \"1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("ratingId").value(rating1.getRatingId()))
                .andExpect(jsonPath("tmdbId").value(rating1.getTmdbId()))
                .andExpect(jsonPath("starRating").value(rating1.getStarRating()))
                .andExpect(jsonPath("comments").value(rating1.getComments()))
                .andExpect(jsonPath("thumbsUpOrDown").value(rating1.isThumbsUpOrDown()))
                .andExpect(jsonPath("userId").value(rating1.getUserID()));
    }

    @Test
    void testAddRating() throws Exception {
        when(ratingService.addNewRating(any(RatingModel.class))).thenReturn(rating1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/rating/save")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(rating1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("tmdbId").value(123));
    }

    @Test
    void deleteRating() throws Exception {
        when(ratingService.deleteById(anyInt())).thenReturn(rating1);

        mockMvc.perform(delete("/api/v1/rating/delete/" + rating1.getRatingId()))
                .andExpect(status().isAccepted());
        verify(ratingService).deleteById(anyInt());
    }
}

