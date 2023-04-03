package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import com.galvanize.bluestwosmoviereviews.services.FriendsListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class FriendsListController {

    FriendsListService friendsListService;

    public FriendsListController(FriendsListService friendsListService)
    {
        this.friendsListService = friendsListService;
    }

    @GetMapping("/friendsList/{userId}/get")
    public ResponseEntity<List<FriendsListModel>> getFriendsList(@PathVariable Integer userId)
    {
        List<FriendsListModel> friends = friendsListService.getFriendsListByID(userId);
        return friends == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(friends);
    }
    @GetMapping("/friendsList/{userId}/{friendId}/get")
    public ResponseEntity<FriendsListModel> getFriend(@PathVariable Integer userId,
                                                            @PathVariable Integer friendId)
    {
        FriendsListModel friend = friendsListService.getFriendByFriendId(userId, friendId);
        return friend == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(friend);
    }

    @PostMapping("/friendsList/add")
    public ResponseEntity<FriendsListModel> addFriend(@RequestBody FriendsListModel newFriend)
    {
        FriendsListModel friends = friendsListService.addFriend(newFriend);
        return new ResponseEntity<>(friends, HttpStatus.CREATED);
    }

    @DeleteMapping("/friendsList/delete/{friendId}")
    public ResponseEntity<FavoritesListModel> deleteFriend(@PathVariable Integer friendId)
    {
        friendsListService.deleteByFriendID(friendId);
        return ResponseEntity.accepted().build();
    }

}
