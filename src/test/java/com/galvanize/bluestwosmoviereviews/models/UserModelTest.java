package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    UserModel user;

    @Test
    void setUp() {
        user = new UserModel();
    }

    @Test
    void testConstructor() {
        user = new UserModel(1, "test", "test", "test", "test", null, null, null, null);
        assertEquals(1, user.getUser_id());
        assertEquals("test", user.getUsername());
        assertEquals("test", user.getPassword());
        assertEquals("test", user.getEmail());
        assertEquals("test", user.getName());
        assertNull(user.getWatch_list());
        assertNull(user.getFav_list());
        assertNull(user.getHistory());
        assertNull(user.getUser_ratings());
    }


}