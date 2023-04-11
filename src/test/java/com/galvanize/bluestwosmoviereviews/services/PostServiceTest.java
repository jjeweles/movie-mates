package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.PostRepository;
import com.galvanize.bluestwosmoviereviews.models.PostModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    private PostModel post;

    @BeforeEach
    void setUp() {
        post = new PostModel();
        post.setPostID(1);
        post.setPost_title("Test Post");
        post.setPost_text("Test Post Text");
    }

    @Test
    void getAllPosts() {
        postService.getAllPosts();
        verify(postRepository, times(1)).findAll();
    }

    @Test
    void getPostsByID() {
        when(postRepository.findPostsByUserID(1)).thenReturn(Collections.singletonList(post));
        postService.getPostsByID(1);
        verify(postRepository, times(1)).findPostsByUserID(1);
    }

    @Test
    void addPost() {
        postService.addPost(post);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void updatePost() {
        when(postRepository.findPostsByPostID(1)).thenReturn(post);
        PostModel updatedPost = new PostModel();
        updatedPost.setPost_title("Updated Post");
        updatedPost.setPost_text("Updated Post Text");
        postService.updatePost(1, updatedPost);
        verify(postRepository, times(1)).findPostsByPostID(1);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    void deletePost() {
        when(postRepository.findPostsByPostID(1)).thenReturn(post);
        postService.deletePost(1);
        verify(postRepository, times(1)).findPostsByPostID(1);
        verify(postRepository, times(1)).delete(post);
    }

    @Test
    void getPostsByPostID() {
        when(postRepository.findPostsByPostID(1)).thenReturn(post);
        postService.getPostsByPostID(1);
        verify(postRepository, times(1)).findPostsByPostID(1);
    }
}
