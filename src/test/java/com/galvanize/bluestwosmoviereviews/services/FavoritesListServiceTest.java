package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FavoritesListServiceTest {
    FavoritesListService favoritesListService;

    @Mock
    FavoritesListRepository favoritesListRepository;
    @BeforeEach
    void setUp()
    {
        favoritesListService = new FavoritesListService(favoritesListRepository);
    }
    @Test
    void getFavoritesListByUserId()
    {
        List<FavoritesListModel> favorites = new ArrayList<>();
        favorites.add(new FavoritesListModel(1122, 2));
        favorites.add(new FavoritesListModel(1133, 2));

        when(favoritesListRepository.findByUserID(2)).thenReturn(favorites);
        List<FavoritesListModel> result = favoritesListService.getFavoritesListByID(2);
        assertEquals(2, result.size());
        assertEquals(favorites, result);
    }
    @Test
    public void testAddTmdbIdToFavoritesList() {

        FavoritesListModel favoritesListModel = new FavoritesListModel(1122, 2);

        when(favoritesListRepository.save(any(FavoritesListModel.class))).thenReturn(favoritesListModel);

        FavoritesListModel result = favoritesListService.addToFavorites(favoritesListModel);

        assertThat(result).isNotNull();
        assertThat(result.getTmdbId()).isEqualTo(1122);
    }
    @Test
    void deleteUserShouldReturnUser() throws Exception {
        FavoritesListModel favoritesListModel = new FavoritesListModel(1122, 1);
    }
}
