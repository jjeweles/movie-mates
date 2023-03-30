package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WatchListModelTest {

    @Test
    void returns123UsingConstructors() {

        WatchListModel history = new WatchListModel( 2, 3);
        assertEquals(2, history.getTmdbId());
        assertEquals(3, history.getId());
    }
}