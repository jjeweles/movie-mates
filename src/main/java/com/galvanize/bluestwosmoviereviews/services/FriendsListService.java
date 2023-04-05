package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FriendsListRepository;
import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsListService {
    private final FriendsListRepository friendsListRepository;

    public FriendsListService(FriendsListRepository friendsListRepository)
    {
        this.friendsListRepository = friendsListRepository;
    }

    public List<FriendsListModel> getFriendsListByID(Integer userId) {
        return friendsListRepository.findByUserId(userId);
    }

    public FriendsListModel getFriendByFriendId(Integer userId, Integer friendId) {
        return friendsListRepository.findByUserIdAndFriendId(userId, friendId);
    }

    public FriendsListModel addFriend(FriendsListModel friendsListModel)
    {
        return friendsListRepository.save(friendsListModel);
    }

    public void deleteByFriendID(Integer userId, Integer friendId)
    {
        FriendsListModel friendsListModel = friendsListRepository.findByUserIdAndFriendId(userId, friendId);
        friendsListRepository.delete(friendsListModel);
    }

    public List<FriendsListModel> getAllFriends() {
        return friendsListRepository.findAll();
    }
}
