package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FavoritesListModelTest {

    FavoritesListModel favoritesListModel;

    @Test
    void setUp() {
        favoritesListModel = new FavoritesListModel(222,3);
    }

    @Test
    void returns1_For_favId()
    {
        FavoritesListModel favoritesListModel = new FavoritesListModel(2, 3);
        assertEquals(favoritesListModel.getTmdbId(), 2);
    }

    @Test
    void returns2_For_tmdbId()
    {
        FavoritesListModel favoritesListModel = new FavoritesListModel(22, 3);
        assertEquals(favoritesListModel.getTmdbId(), 22);
    }

    @Test
    void returns3_For_tmdbId()
    {
        FavoritesListModel favoritesListModel = new FavoritesListModel( 2, 3);
        assertEquals(favoritesListModel.getUserID(), 3);
    }
}