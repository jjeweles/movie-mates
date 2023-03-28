package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryModelTest {

    @Test
    void returns123UsingConstructors(){
        HistoryModel history = new HistoryModel(1,2,3);
        assertEquals(1, history.getHistoryId());
        assertEquals(2, history.getTmdbId());
        assertEquals(3, history.getUserId());
    }
}