package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class FriendsListModel {

    @Id
    @Column(name = "user_Id")
    Integer userId;
    @Column(name = "friend_Id")
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
