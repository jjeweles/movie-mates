package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FavoritesListModelTest {

    FavoritesListModel favoritesListModel;
    @Test
    void setUp() {
        favoritesListModel = new FavoritesListModel(1,2,3);
    }
    @Test
    void returns1_For_favId()
    {
        FavoritesListModel favoritesListModel = new FavoritesListModel(1, 2, 3);
        assertEquals(favoritesListModel.favListId, 1);
    }
    @Test
    void returns2_For_tmdbId()
    {
        FavoritesListModel favoritesListModel = new FavoritesListModel(1, 2, 3);
        assertEquals(favoritesListModel.tmdbId, 2);
    }
    @Test
    void returns3_For_tmdbId()
    {
        FavoritesListModel favoritesListModel = new FavoritesListModel(1, 2, 3);
        assertEquals(favoritesListModel.userId, 3);
    }
}