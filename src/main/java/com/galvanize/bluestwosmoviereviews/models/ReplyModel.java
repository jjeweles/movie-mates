package com.galvanize.bluestwosmoviereviews.models;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

@Entity
@Table(name = "replies")
public class ReplyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replyID;

    @Column(name = "reply_text")
    private String reply_text;


    @Column(name = "userID")
    private Integer userID;


    @Column(name = "postID")
    private Integer postID;

    public ReplyModel(){
    }

    public ReplyModel(Integer replyID, String reply_text, Integer userID, Integer postID) {
        this.replyID = replyID;
        this.reply_text = reply_text;
        this.userID = userID;
        this.postID = postID;
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

    public Integer getReplyByUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReplyModel that = (ReplyModel) o;
        return Objects.equals(replyID, that.replyID) && Objects.equals(reply_text, that.reply_text) && Objects.equals(userID, that.userID) && Objects.equals(postID, that.postID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyID, reply_text, userID, postID);
    }

    @Override
    public String toString() {
        return "ReplyModel{" +
                "replyID=" + replyID +
                ", reply_text='" + reply_text + '\'' +
                ", userID=" + userID +
                ", postID=" + postID +
                '}';
    }
}
