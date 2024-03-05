package com.example.blog.controller;

import com.example.blog.service.PostService;
import com.example.blog.service.dto.PostRequestDTO;
import com.example.blog.service.dto.PostResponseDTO;
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
    public List<PostResponseDTO> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/search/first-by-title")
    public PostResponseDTO getFirstPostByTitle(@RequestParam(name = "query", required = true) String title) {
        return postService.getPostByTitle(title);
    }

    @PostMapping("/")
    public PostResponseDTO save(@RequestBody PostRequestDTO postRequestDTO) {
        return postService.createPost(postRequestDTO);
    }

}
