package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FriendsListRepository;
import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FriendsListServiceTest {

    @Mock
    private FriendsListRepository friendsListRepository;

    @InjectMocks
    private FriendsListService friendsListService;

    private FriendsListModel friend;

    @BeforeEach
    void setUp() {
        friend = new FriendsListModel();
        friend.setFriendsListId(1);
        friend.setUserId(1);
        friend.setFriendId(2);
    }

    @Test
    void getFriendsListByID() {
        when(friendsListRepository.findByUserId(1)).thenReturn(Collections.singletonList(friend));
        friendsListService.getFriendsListByID(1);
        verify(friendsListRepository, times(1)).findByUserId(1);
    }

    @Test
    void getFriendByFriendId() {
        when(friendsListRepository.findByUserIdAndFriendId(1, 2)).thenReturn(friend);
        friendsListService.getFriendByFriendId(1, 2);
        verify(friendsListRepository, times(1)).findByUserIdAndFriendId(1, 2);
    }

    @Test
    void addFriend() {
        friendsListService.addFriend(friend);
        verify(friendsListRepository, times(1)).save(friend);
    }

    @Test
    void deleteByFriendID() {
        when(friendsListRepository.findByUserIdAndFriendId(1, 2)).thenReturn(friend);
        friendsListService.deleteByFriendID(1, 2);
        verify(friendsListRepository, times(1)).findByUserIdAndFriendId(1, 2);
        verify(friendsListRepository, times(1)).delete(friend);
    }

    @Test
    void getAllFriends() {
        friendsListService.getAllFriends();
        verify(friendsListRepository, times(1)).findAll();
    }
}
