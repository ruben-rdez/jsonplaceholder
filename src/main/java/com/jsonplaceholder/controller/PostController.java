package com.jsonplaceholder.controller;

import com.jsonplaceholder.model.Post;
import com.jsonplaceholder.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Tag(name = "Posts", description = "Operations related to posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/external")
    @Operation(summary = "Fetch all posts from external API", 
        description = "Retrieves all posts from the external JSONPlaceholder API.")
    public List<Post> getAllPosts() {
        return postService.fetchAllFromExternalApi();
    }

    @GetMapping("/local")
    @Operation(summary = "Fetch all local posts", 
        description = "Retrieves all posts stored locally in the database.")
    public List<Post> getLocalPosts() {
        return postService.getAllLocalPosts();
    }

    @PostMapping
    @Operation(summary = "Create a new post", 
        description = "Creates a new post and saves it locally in the database.")
    public Post createPost(@RequestBody Post post) {
        return postService.saveLocally(post);
    }

}
