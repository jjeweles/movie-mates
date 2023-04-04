package com.galvanize.bluestwosmoviereviews.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "replies")
public class ReplyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer replyID;

    @Column(name = "reply_text")
    String reply_text;


    @JoinColumn(name = "userID")
    UserModel userModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postID")
    PostModel postModel;

    public ReplyModel(){

    }

    public ReplyModel(Integer replyID, String reply_text, UserModel userModel, PostModel postModel) {
        this.replyID = replyID;
        this.reply_text = reply_text;
        this.userModel = userModel;
        this.postModel = postModel;
    }

    public Integer getReplyID() {
        return replyID;
    }

    public void setReplyID(Integer replyID) {
        this.replyID = replyID;
    }

    public String getReply_text() {
        return reply_text;
    }

    public void setReply_text(String reply_text) {
        this.reply_text = reply_text;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public PostModel getPostModel() {
        return postModel;
    }

    public void setPostModel(PostModel postModel) {
        this.postModel = postModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplyModel that = (ReplyModel) o;
        return Objects.equals(replyID, that.replyID) && Objects.equals(reply_text, that.reply_text) && Objects.equals(userModel, that.userModel) && Objects.equals(postModel, that.postModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyID, reply_text, userModel, postModel);
    }

    @Override
    public String toString() {
        return "ReplyModel{" +
                "replyID=" + replyID +
                ", reply_text='" + reply_text + '\'' +
                ", userModel=" + userModel +
                ", postModel=" + postModel +
                '}';
    }
}
