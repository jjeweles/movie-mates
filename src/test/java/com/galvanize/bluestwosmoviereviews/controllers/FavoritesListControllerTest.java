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
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FavoritesListController.class)
class FavoritesListControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    FavoritesListService favoritesListService;
    FavoritesListModel list1;
    FavoritesListModel list2;
    List<FavoritesListModel> favorites = new ArrayList<>();

    @BeforeEach
    void setUp() {
        list1 = new FavoritesListModel(1122, 3);
        list2 = new FavoritesListModel(1133, 3);
        favorites.add(list1);
        favorites.add(list2);
    }

    @Test
    void getAllFavoritesByUserID() throws Exception {
        when(favoritesListService.getFavoritesListByID(3)).thenReturn(favorites);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/favList/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tmdbId").value(list1.getTmdbId()))
                .andExpect((jsonPath("$[1].tmdbId").value(list2.getTmdbId())));

    }

    @Test
    void returnFavListByUserID() throws Exception {
        when(favoritesListService.getFavoritesListByID(3)).thenReturn(favorites);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/favList/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tmdbId").value(list1.getTmdbId()))
                .andExpect((jsonPath("$[1].tmdbId").value(list2.getTmdbId())));

    }

    @Test
    void addTmdbIdToFavesList() {
        // Given
        FavoritesListModel inputFavoritesListModel = new FavoritesListModel();
        inputFavoritesListModel.setTmdbId(123);
        inputFavoritesListModel.setUserID(1);

        FavoritesListModel expectedFavoritesListModel = new FavoritesListModel();
        expectedFavoritesListModel.setFavoritesID(1);
        expectedFavoritesListModel.setTmdbId(123);
        expectedFavoritesListModel.setUserID(1);

        when(favoritesListService.addNewFavorite(inputFavoritesListModel)).thenReturn(expectedFavoritesListModel);

        // When
        FavoritesListController favoritesListController = new FavoritesListController(favoritesListService);
        ResponseEntity<FavoritesListModel> responseEntity = favoritesListController.addTmdbIdToFavesList(inputFavoritesListModel);

        // Then
        verify(favoritesListService).addNewFavorite(inputFavoritesListModel);

    }

    @Test
    void deleteTmdbIdFromFavList() {
        // Given
        Integer userId = 1;
        Integer tmdbId = 123;

        // When
        FavoritesListController favoritesListController = new FavoritesListController(favoritesListService);
        ResponseEntity<FavoritesListModel> responseEntity = favoritesListController.deleteTmdbIdFromFavList(userId, tmdbId);

        // Then
        verify(favoritesListService).deleteByTmbdId(userId, tmdbId);
    }
}
