package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class FriendsListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer friendsListId;
    @Column(name = "friend_Id")
    private Integer friendId;

    @Column(name = "user_Id")
    private Integer userId;

    public FriendsListModel(Integer userId, Integer friendId) {
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

    public Integer getFriendsListId() {
        return friendsListId;
    }

    public void setFriendsListId(Integer friendsListId) {
        this.friendsListId = friendsListId;
    }
}
