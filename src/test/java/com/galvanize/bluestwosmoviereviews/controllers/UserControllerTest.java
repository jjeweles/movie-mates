package com.galvanize.bluestwosmoviereviews.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    ObjectMapper objectMapper = new ObjectMapper();

    // api/v1/users/{id} GET
    @Test
    void getUserByIDShouldReturnUser() throws Exception {

        UserModel user = new UserModel(1, "test", "test", "test", "test", null, null, null, null);

        when(userService.getUserByID(1)).thenReturn(user);
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1));

    }

    @Test
    void getUserByIDShouldReturnNoContent() throws Exception {

        when(userService.getUserByID(1)).thenReturn(null);
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isNoContent());

    }

}