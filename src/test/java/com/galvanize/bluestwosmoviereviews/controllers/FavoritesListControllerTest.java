package com.galvanize.bluestwosmoviereviews.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.FavoritesListService;
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

import javax.print.attribute.standard.Media;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
class FavoritesListControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    FavoritesListService favoritesListService;
    FavoritesListModel list1;
    FavoritesListModel list2;
    List<FavoritesListModel> favorites;
    @BeforeEach
    void setUp()
    {
        list1 = new FavoritesListModel(1122,3);
        list2 = new FavoritesListModel(1133,3);
        favorites.add(list1);
        favorites.add(list2);
    }
    @Test
    void getAllFavorites ()throws Exception
    {
        when(favoritesListService.getFavoritesListByID(3)).thenReturn(favorites);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/favList/get")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tmbdId").value(list1.getTmdbId()))
                .andExpect((jsonPath("$.tmbdId").value(list2.getTmdbId())));

    }
    @Test
    void testAddTmdbIdToFavList() throws Exception {
        when(favoritesListService.addToFavorites(any(FavoritesListModel.class))).thenReturn(list1);

        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/favList/save")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(list1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.tmdbId").value(1122));
    }

    @Test
    void deleteRating() throws Exception {
        FavoritesListModel favoritesListModel = new FavoritesListModel(1122, 3);

        mockMvc.perform(delete("/api/v1/favList/delete" + list1)
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":\"3\",\"tmdbId\":\"1122\"}"))
                .andExpect(status().isAccepted());
        verify(favoritesListService).deleteByTmbdId(favoritesListModel);
    }

}
