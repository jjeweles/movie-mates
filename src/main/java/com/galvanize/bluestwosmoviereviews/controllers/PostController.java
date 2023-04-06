package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.CategoryModel;
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

    public PostController(PostService postService, ReplyService replyService, CategoryService categoryService){
        this.postService = postService;
        this.replyService = replyService;
        this.categoryService = categoryService;
    }

    @GetMapping("posts")
    public Iterable<PostModel> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("posts/userposts/{userID}")
    public ResponseEntity<PostModel> getPostsByID(@PathVariable Integer userID){
        PostModel post = postService.getPostsByID(userID);

        return post == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(post);
    }

    @GetMapping("posts/findpost/{postID}")
    public ResponseEntity <PostModel> findPostsByPostID(@PathVariable Integer postID){
        PostModel reply = postService.getPostsByPostID(postID);
        return reply == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(reply);
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

    @GetMapping("posts/reply")
    public Iterable<ReplyModel> getAllReplies(){
        return replyService.getAllReplies();
    }

    @GetMapping("posts/reply/user/{userID}")
    public ResponseEntity<List<ReplyModel>> getReplyByID(@PathVariable Integer userID){
        List<ReplyModel> reply = replyService.getReplyByUserID(userID);

        return reply == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(reply);
    }

    @GetMapping("posts/reply/post/{postID}")
    public ResponseEntity <List<ReplyModel>> findReplyByPostID(@PathVariable Integer postID){
        List<ReplyModel> reply = replyService.findReplyByPostID(postID);

        return reply == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(reply);
    }

    @PostMapping("posts/reply")
    public ReplyModel addReply(@RequestBody ReplyModel reply){
        return replyService.addReply(reply);
    }

    @PostMapping("posts/reply/post/{postID}")
    public ReplyModel addReply(@PathVariable Integer postID, @RequestBody ReplyModel reply){
        return replyService.addReply(reply);
    }

    @PostMapping("posts/reply/")
    public ReplyModel addReplyToReply(@RequestBody ReplyModel reply){
        return replyService.addReply(reply);
    }

    @PutMapping("posts/reply/{replyID}")
    public ReplyModel updateReply(@PathVariable Integer replyID, @RequestBody ReplyModel reply){
        return replyService.updateReply(replyID, reply);
    }

    @DeleteMapping("posts/reply/{replyID}")
    public ResponseEntity<ReplyModel> deleteReply(@PathVariable Integer replyID){
        ReplyModel deletePost = replyService.deletePost(replyID);
        return deletePost == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletePost);
    }

    /// ----- CATEGORY ENDPOINTS ----- \\\

    @GetMapping("posts/category")
    public Iterable<CategoryModel> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("posts/category/{categoryID}")
    public ResponseEntity <CategoryModel> findCategoryByID(@PathVariable Integer categoryID){
        CategoryModel reply = categoryService.findCategoryByCategoryID(categoryID);

        return reply == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(reply);
    }

    @PostMapping("posts/category")
    public CategoryModel addCategory(@RequestBody CategoryModel category){
        return categoryService.addCategory(category);
    }

    @PutMapping("posts/category/{categoryID}")
    public CategoryModel updateCategory(@PathVariable Integer categoryID, @RequestBody CategoryModel category){
        return categoryService.updateCategory(categoryID, category);
    }

    @DeleteMapping("posts/category/{categoryID}")
    public ResponseEntity<CategoryModel> deleteCategory(@PathVariable Integer categoryID){
        CategoryModel deleteCategory = categoryService.deleteCategoryByCategoryID(categoryID);
        return deleteCategory == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deleteCategory);
    }

}
