package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import com.galvanize.bluestwosmoviereviews.services.FriendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class FriendsListController {

    private final FriendsListService friendsListService;

    @Autowired
    FriendsListController(FriendsListService friendsListService)
    {
        this.friendsListService = friendsListService;
    }

    @GetMapping("/friendsList/get")
    public ResponseEntity<List<FriendsListModel>> getAllFriends() {
        List<FriendsListModel> ratings = friendsListService.getAllFriends();
        return ratings == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(ratings);
    }

    @GetMapping("/friendsList/{userId}/get")
    public ResponseEntity<List<FriendsListModel>> getFriendsList(@PathVariable Integer userId) {
        List<FriendsListModel> friends = friendsListService.getFriendsListByID(userId);
        return friends == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(friends);
    }

    @GetMapping("/friendsList/{userId}/{friendId}/get")
    public ResponseEntity<FriendsListModel> getFriend(@PathVariable Integer userId, @PathVariable Integer friendId) {
        FriendsListModel friend = friendsListService.getFriendByFriendId(userId, friendId);
        return friend == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(friend);
    }

    @PostMapping("/friendsList/add")
    public ResponseEntity<FriendsListModel> addFriend(@RequestBody FriendsListModel newFriend) {
        List<FriendsListModel> friendList = friendsListService.getFriendsListByID(newFriend.getUserId());
        for (FriendsListModel e : friendList) {
                if (e.getFriendId().equals(newFriend.getFriendId())) {
                    return ResponseEntity.badRequest().build();
                }
        }
        FriendsListModel friends = friendsListService.addFriend(newFriend);
        return new ResponseEntity<>(friends, HttpStatus.CREATED);
    }

    @DeleteMapping("/friendsList/delete/{userId}/{friendId}")
    public ResponseEntity<FriendsListModel> deleteFriend(@PathVariable Integer userId, @PathVariable Integer friendId) {
        List<FriendsListModel> friendList = friendsListService.getFriendsListByID(userId);
        for(FriendsListModel checkForFriend: friendList) {
            if(checkForFriend.getFriendId().equals(friendId)){
                friendsListService.deleteByFriendID(userId, friendId);
                return ResponseEntity.accepted().build();
            }
        }
        return ResponseEntity.noContent().build();
    }
}
