package com.galvanize.bluestwosmoviereviews.models;

public class FriendsListModel {

    Integer userId;
    Integer friendId;

    public FriendsListModel() {
    }

    public FriendsListModel(FriendsListModel newFriend)
    {
        this.userId = newFriend.getUserId();
        this.friendId = newFriend.getFriendId();
    }
    public FriendsListModel(Integer userId, Integer friendId)
    {
        this.userId = userId;
        this.friendId = friendId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }


}
