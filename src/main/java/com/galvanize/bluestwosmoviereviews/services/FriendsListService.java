package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FriendsListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FriendsListService {
    private final FriendsListRepository friendsListRepository;

    @Autowired
    FriendsListService(FriendsListRepository friendsListRepository)
    {
        this.friendsListRepository = friendsListRepository;
    }
    public List<FriendsListModel> getFriendsListByID(Integer userId) {
        return friendsListRepository.findByUserId(userId);
    }

    public FriendsListModel getFriendByFriendId(Integer userId, Integer friendId) {
        return friendsListRepository.findByUserId(userId, friendId);
    }

    public FriendsListModel addFriend(FriendsListModel friendsListModel)
    {
        return friendsListRepository.save(friendsListModel);
    }

    public void deleteByFriendID(Integer friendId)
    {
        friendsListRepository.deleteById(friendId);
    }
}
