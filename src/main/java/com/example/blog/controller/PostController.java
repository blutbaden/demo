package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/getTitle")
    public Post getPostByTile(@RequestParam(name = "query", required = true) String title) {
        return postService.getPostByTitle(title);
    }

    @PostMapping("/")
    public Post save(@RequestBody Post post) {
        return postService.createPost(post);
    }

}
