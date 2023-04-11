package com.galvanize.bluestwosmoviereviews.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import com.galvanize.bluestwosmoviereviews.services.FriendsListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FriendsListController.class)
class FriendsListControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FriendsListService friendsListService;

    FriendsListModel friendsList = new FriendsListModel();

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        friendsList.setFriendsListId(1);
        friendsList.setUserId(1);
        friendsList.setFriendId(2);
    }

    @Test
    void getAllFriendsShouldReturnListOfAllFriends() throws Exception {
        List<FriendsListModel> friendsList = new ArrayList<>();
        when(friendsListService.getAllFriends()).thenReturn(friendsList);
        mockMvc.perform(get("/api/v1/friendsList/get"))
                .andExpect(status().isOk());
    }

    @Test
    void getFriendsList() throws Exception {
        List<FriendsListModel> friendsList = new ArrayList<>();
        when(friendsListService.getFriendsListByID(1)).thenReturn(friendsList);
        mockMvc.perform(get("/api/v1/friendsList/1/get"))
                .andExpect(status().isOk());
    }

    @Test
    void getFriend() throws Exception {
        FriendsListModel friendsList = new FriendsListModel();
        when(friendsListService.getFriendByFriendId(1, 2)).thenReturn(friendsList);
        mockMvc.perform(get("/api/v1/friendsList/1/2/get"))
                .andExpect(status().isOk());
    }

    @Test
    void addFriend() throws Exception {
        FriendsListModel friendsList = new FriendsListModel();
        when(friendsListService.addFriend(friendsList)).thenReturn(friendsList);
        mockMvc.perform(post("/api/v1/friendsList/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(friendsList)))
                .andExpect(status().isCreated());
    }
}