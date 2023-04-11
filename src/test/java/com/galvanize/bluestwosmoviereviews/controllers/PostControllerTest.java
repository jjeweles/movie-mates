package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.CategoryModel;
import com.galvanize.bluestwosmoviereviews.models.PostModel;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import com.galvanize.bluestwosmoviereviews.services.CategoryService;
import com.galvanize.bluestwosmoviereviews.services.PostService;
import com.galvanize.bluestwosmoviereviews.services.ReplyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService postService;

    @Mock
    private ReplyService replyService;

    @Mock
    private CategoryService categoryService;

    @Test
    void getAllPosts() {
        postController.getAllPosts();
        verify(postService, times(1)).getAllPosts();
    }

    @Test
    void getPostsByUserID() {
        postController.getPostsByUserID(1);
        verify(postService, times(1)).getPostsByID(1);
    }

    @Test
    void findPostsByPostID() {
        postController.findPostsByPostID(1);
        verify(postService, times(1)).getPostsByPostID(1);
    }

    @Test
    void addPost() {
        PostModel post = new PostModel();
        postController.addPost(post);
        verify(postService, times(1)).addPost(post);
    }

    @Test
    void updatePost() {
        PostModel post = new PostModel();
        postController.updatePost(1, post);
        verify(postService, times(1)).updatePost(1, post);
    }

    @Test
    void deletePost() {
        postController.deletePost(1);
        verify(postService, times(1)).deletePost(1);
    }

    @Test
    void getAllReplies() {
        postController.getAllReplies();
        verify(replyService, times(1)).getAllReplies();
    }

    @Test
    void getReplyByID() {
        postController.getReplyByID(1);
        verify(replyService, times(1)).getReplyByUserID(1);
    }

    @Test
    void findReplyByPostID() {
        postController.findReplyByPostID(1);
        verify(replyService, times(1)).findReplyByPostID(1);
    }

    @Test
    void addReply() {
        ReplyModel reply = new ReplyModel();
        postController.addReply(reply);
        verify(replyService, times(1)).addReply(reply);
    }

    @Test
    void addReplyByPostID() {
        ReplyModel reply = new ReplyModel();
        postController.addReply(1, reply);
        verify(replyService, times(1)).addReply(reply);
    }

    @Test
    void addReplyToReply() {
        ReplyModel reply = new ReplyModel();
        postController.addReplyToReply(reply);
        verify(replyService, times(1)).addReply(reply);
    }

    @Test
    void updateReply() {
        ReplyModel reply = new ReplyModel();
        postController.updateReply(1, reply);
        verify(replyService, times(1)).updateReply(1, reply);
    }

    @Test
    void deleteReply() {
        postController.deleteReply(1);
        verify(replyService, times(1)).deletePost(1);
    }

    @Test
    void getAllCategories() {
        postController.getAllCategories();
        verify(categoryService, times(1)).findAllCategories();
    }

    @Test
    void findCategoryByID() {
        postController.findCategoryByID(1);
        verify(categoryService, times(1)).findCategoryByCategoryID(1);
    }

    @Test
    void addCategory() {
        CategoryModel category = new CategoryModel();
        postController.addCategory(category);
        verify(categoryService, times(1)).addCategory(category);
    }

    @Test
    void updateCategory() {
        CategoryModel category = new CategoryModel();
        postController.updateCategory(1, category);
        verify(categoryService, times(1)).updateCategory(1, category);
    }

    @Test
    void deleteCategory() {
        postController.deleteCategory(1);
        verify(categoryService, times(1)).deleteCategoryByCategoryID(1);
    }
}