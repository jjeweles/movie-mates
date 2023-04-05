//package com.galvanize.bluestwosmoviereviews.services;
//
//import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
//import com.galvanize.bluestwosmoviereviews.data.FriendsListRepository;
//import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//public class FriendsListServiceTest {
//    FriendsListService friendsListService;
//    @Mock
//    FriendsListRepository friendsListRepository;
//    @BeforeEach
//    void setUp()
//    {
//        friendsListService = new FriendsListService(friendsListRepository);
//    }
//    @Test
//    void testShouldReturnListOfFriends()
//    {
//        List<FriendsListModel> friendsList = new ArrayList<>();
//        friendsList.add(new FriendsListModel(1,2));
//
//    }
//
//}