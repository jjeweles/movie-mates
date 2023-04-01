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
        user = new UserModel("test", "test", "test", "test");
        assertEquals("test", user.getUsername());
        assertEquals("test", user.getPassword());
        assertEquals("test", user.getEmail());
        assertEquals("test", user.getName());
    }


}