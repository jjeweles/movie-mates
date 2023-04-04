package com.galvanize.bluestwosmoviereviews.controllers;


import com.galvanize.bluestwosmoviereviews.models.PostModel;
import com.galvanize.bluestwosmoviereviews.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class PostController {

    PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("posts")
    public Iterable<PostModel> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("posts/{userID}")
    public ResponseEntity<PostModel> getPostsByID(@PathVariable Integer userID){
        PostModel post = postService.getPostsByID(userID);

        return post == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(post);
    }

    @PostMapping("posts/add")
    public PostModel addPost(@RequestBody PostModel post){
        return postService.addPost(post);
    }

    @PutMapping("posts/{postID}")
        public PostModel updatePost(@PathVariable Integer postID, @RequestBody PostModel post){
            return postService.updatePost(postID, post);
    }

    @DeleteMapping("posts/{postID}")
    public ResponseEntity<PostModel> deletePost(@PathVariable Integer postID){
        PostModel deletePost = postService.deletePost(postID);
        return deletePost == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletePost);
    }
}
