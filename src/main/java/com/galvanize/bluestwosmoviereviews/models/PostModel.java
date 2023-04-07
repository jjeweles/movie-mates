package com.galvanize.bluestwosmoviereviews.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postID;

    @Column(name = "post_title")
    private String post_title;

    @Column(name = "post_text")
    private String post_text;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "categoryID")
    private Integer categoryID;

    public PostModel() {
    }

    public PostModel(Integer postID, String post_title, String post_text, Integer userID, Integer categoryID, Integer replyID) {
        this.postID = postID;
        this.post_title = post_title;
        this.post_text = post_text;
        this.userID = userID;
        this.categoryID = categoryID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostModel postModel = (PostModel) o;
        return Objects.equals(postID, postModel.postID) && Objects.equals(post_title, postModel.post_title) && Objects.equals(post_text, postModel.post_text) && Objects.equals(userID, postModel.userID) && Objects.equals(categoryID, postModel.categoryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, post_title, post_text, userID, categoryID);
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "postID=" + postID +
                ", post_title='" + post_title + '\'' +
                ", post_text='" + post_text + '\'' +
                ", userID=" + userID +
                ", categoryID=" + categoryID +
                '}';
    }

}