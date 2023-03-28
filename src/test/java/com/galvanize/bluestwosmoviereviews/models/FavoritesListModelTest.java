package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FavoritesListModelTest {
    @Test
    void returns1_2_3forInputsOnConstructor()
    {
        FavoritesListModel favList = new FavoritesListModel(1,2,3);
        assertEquals(1, favList.getFavListId());
        assertEquals(2, favList.getTmdbId());
        assertEquals(3, favList.getUserId());
    }
}