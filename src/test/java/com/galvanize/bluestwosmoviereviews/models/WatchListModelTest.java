package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchListModelTest {

    @Test
    void returns123UsingConstructors() {

        WatchListModel watchList = new WatchListModel( 1, 2);
        assertEquals(2, watchList.getTmdbID());
        assertEquals(0, watchList.getWatchlistID());
        assertEquals(1, watchList.getUserID());
    }
}