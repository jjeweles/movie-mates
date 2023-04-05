package com.galvanize.bluestwosmoviereviews.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import com.galvanize.bluestwosmoviereviews.services.WatchListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class WatchListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WatchListService watchListService;

    private List<WatchListModel> watchList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        WatchListModel movie1 = new WatchListModel(1, 12345);
        WatchListModel movie2 = new WatchListModel(1, 67890);

        watchList = Arrays.asList(movie1, movie2);
    }

    @Test
    void getWatchListById() throws Exception {
        when(watchListService.getWatchList(1)).thenReturn(watchList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/watchlist/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(watchList)));
    }

    @Test
    void addMovie() throws Exception {
        WatchListModel movie = new WatchListModel();
        movie.setUserID(1);
        movie.setTmdbID(12345);

        when(watchListService.addToWatchList(movie)).thenReturn(movie);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/watchlist/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(movie)));
    }


    @Test
    void deleteMovie() throws Exception {
        WatchListModel deletedMovie = new WatchListModel(1, 12345);

        when(watchListService.deleteFromWatchList(1, 12345)).thenReturn(deletedMovie);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/watchlist/1/12345"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(deletedMovie)));
    }

    @Test
    void deleteAllWatchList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/watchlist/deleteAll/1"))
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}
