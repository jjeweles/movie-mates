package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FavoritesListServiceTest {
    FavoritesListService favoritesListService;

    @Mock
    FavoritesListRepository favoritesListRepository;

    FavoritesListModel favoritesListModel;
    @BeforeEach
    void setUp()
    {
        favoritesListService = new FavoritesListService(favoritesListRepository);
    }
    @Test
    void getFavoritesListByUserId()
    {
        List<FavoritesListModel> favorites = new ArrayList<>();
        favorites.add(new FavoritesListModel(1, 1122, 2));
        favorites.add(new FavoritesListModel(1, 1133, 2));

        when(favoritesListRepository.findByUserId(2)).thenReturn(favorites);
        List<FavoritesListModel> result = favoritesListService.getFavoritesListByID(2);
        assertEquals(2, result.size());
        assertEquals(favorites, result);
    }
}
