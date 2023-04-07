package com.galvanize.bluestwosmoviereviews.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

        UserModel user = new UserModel("test", "test", "test", "test");
        user.setUserID(1);
        when(userService.getUserByID(1)).thenReturn(user);
        mockMvc.perform(get("/api/v1/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(1));

    }

    @Test
    void getUserByIDShouldReturnNoContent() throws Exception {

        when(userService.getUserByID(1)).thenReturn(null);
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isNoContent());

    }

    @Test
    void addUserShouldReturnUser() throws Exception {

        UserModel user = new UserModel("test", "test", "test", "test");

        when(userService.addUser(user)).thenReturn(user);
        mockMvc.perform(post("/api/v1/users/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void addUserShouldReturnNoContent() throws Exception {

        UserModel user = new UserModel("test", "test", "test", "test");

        when(userService.addUser(user)).thenReturn(null);
        mockMvc.perform(post("/api/v1/users/add")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }

    @Test
    void updateUserShouldReturnUser() throws Exception {

        UserModel user = new UserModel("test", "test", "test", "test");

        when(userService.updateUser(1, user)).thenReturn(user);
        mockMvc.perform(put("/api/v1/users/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }

    @Test
    void updateUserShouldReturnNoContent() throws Exception {

        UserModel user = new UserModel("test", "test", "test", "test");

        when(userService.updateUser(1, user)).thenReturn(null);
        mockMvc.perform(put("/api/v1/users/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }

    @Test
    void deleteUserShouldReturnUser() throws Exception {

        UserModel user = new UserModel("test", "test", "test", "test");
        user.setUserID(1);
        when(userService.deleteUser(1)).thenReturn(user);
        mockMvc.perform(delete("/api/v1/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(1));

    }

    @Test
    void deleteUserShouldReturnNoContent() throws Exception {

        when(userService.deleteUser(1)).thenReturn(null);
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().isNoContent());

    }

}