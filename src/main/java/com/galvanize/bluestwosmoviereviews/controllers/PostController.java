package com.galvanize.bluestwosmoviereviews.controllers;


import com.galvanize.bluestwosmoviereviews.models.PostModel;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import com.galvanize.bluestwosmoviereviews.services.CategoryService;
import com.galvanize.bluestwosmoviereviews.services.PostService;
import com.galvanize.bluestwosmoviereviews.services.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class PostController {

    PostService postService;
    ReplyService replyService;
    CategoryService categoryService;

    public PostController(){

    }

    public PostController(PostService postService, ReplyService replyService, CategoryService categoryService){
        this.postService = postService;
        this.replyService = replyService;
        this.categoryService = categoryService;
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


    /// ----- REPLY ENDPOINTS ----- \\\

//    @GetMapping("posts/reply")
//    public Iterable<ReplyModel> getAllReplies(){
//        return replyService.getAllReplies();
//    }
//
//    @GetMapping("posts/reply/{userID}")
//    public ResponseEntity<ReplyModel> getReplyByID(@PathVariable Integer userID){
//        ReplyModel reply = replyService.getReplyByID(userID);
//
//        return reply == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(reply);
//    }
//    @GetMapping("posts/reply/{postID}")
//    public ResponseEntity <List<ReplyModel>> findReplyByPostID(@PathVariable Integer postID){
//        List<ReplyModel> reply = (List<ReplyModel>) replyService.findReplyByPostID(postID);
//
//        return reply == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(reply);
//    }
//
//    @PostMapping("posts/reply/{postID}")
//    public ReplyModel addReply(@PathVariable Integer postID, @RequestBody ReplyModel reply){
//        return replyService.addPost(reply);
//    }
//
//    @PostMapping("posts/reply/{replyID}")
//    public ReplyModel addReplyToReply(@PathVariable Integer replyID, @RequestBody ReplyModel reply){
//        return replyService.addPost(reply);
//    }
//
//    @PutMapping("posts/{replyID}")
//    public ReplyModel updateReply(@PathVariable Integer replyID, @RequestBody ReplyModel reply){
//        return replyService.updateReply(replyID, reply);
//    }
//
//    @DeleteMapping("posts/{replyID}")
//    public ResponseEntity<ReplyModel> deleteReply(@PathVariable Integer replyID){
//        ReplyModel deletePost = replyService.deletePost(replyID);
//        return deletePost == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletePost);
//    }


    /// ----- CATEGORY ENDPOINTS ----- \\\

}
