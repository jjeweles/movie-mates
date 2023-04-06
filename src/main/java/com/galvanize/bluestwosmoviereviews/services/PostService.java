package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.PostRepository;
import com.galvanize.bluestwosmoviereviews.models.PostModel;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Iterable<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    public PostModel getPostsByID(Integer userID){
        return postRepository.findPostsByUserID(userID);
    }

    public PostModel addPost(PostModel post){
        return postRepository.save(post);
    }

    public PostModel updatePost(Integer postID, PostModel post){
        PostModel postToUpdate = postRepository.findPostsByPostID(postID);

        if(postToUpdate != null){
            postToUpdate.setPost_title(post.getPost_title());
            postToUpdate.setPost_text(post.getPost_text());
        }

        assert postToUpdate != null;
        return postRepository.save(postToUpdate);
    }

    public PostModel deletePost (Integer postID){
        PostModel postToDelete = postRepository.findPostsByPostID(postID);
        if (postToDelete != null){
            postRepository.delete(postToDelete);
        }
        return postToDelete;
    }

}
