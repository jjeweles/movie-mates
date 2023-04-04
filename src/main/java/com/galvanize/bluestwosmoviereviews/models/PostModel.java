package com.galvanize.bluestwosmoviereviews.models;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer postID;

    @Column(name = "post_title")
    String post_title;

    @Column(name = "post_text")
    String post_text;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    UserModel userModel;

    @JoinColumn(name = "categoryID")
    CategoryModel categoryModel;

    @OneToMany(mappedBy = "postModel")
    @Column(name = "replyID")
    List<ReplyModel> replyModel;


    public PostModel(){
    }

    public PostModel(Integer postID, String post_title, String post_text, UserModel userModel, CategoryModel categoryModel, List<ReplyModel> replyModel) {
        this.postID = postID;
        this.post_title = post_title;
        this.post_text = post_text;
        this.userModel = userModel;
        this.categoryModel = categoryModel;
        this.replyModel = replyModel;
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

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public List<ReplyModel> getReplyModel() {
        return replyModel;
    }

    public void setReplyModel(List<ReplyModel> replyModel) {
        this.replyModel = replyModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostModel postModel = (PostModel) o;
        return Objects.equals(postID, postModel.postID) && Objects.equals(post_title, postModel.post_title) && Objects.equals(post_text, postModel.post_text) && Objects.equals(userModel, postModel.userModel) && Objects.equals(categoryModel, postModel.categoryModel) && Objects.equals(replyModel, postModel.replyModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, post_title, post_text, userModel, categoryModel, replyModel);
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "postID=" + postID +
                ", post_title='" + post_title + '\'' +
                ", post_text='" + post_text + '\'' +
                ", userModel=" + userModel +
                ", categoryModel=" + categoryModel +
                ", replyModel=" + replyModel +
                '}';
    }
}

