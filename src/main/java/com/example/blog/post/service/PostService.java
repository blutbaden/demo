package com.example.blog.post.service;

import com.example.blog.post.model.Post;
import com.example.blog.post.repository.PostRepository;
import com.example.blog.post.service.dto.PostRequestDTO;
import com.example.blog.post.service.dto.PostResponseDTO;
import com.example.blog.post.service.mapper.PostMapper;
import com.example.blog.post.service.mapper.PostResponseMapper;
import com.example.blog.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final PostResponseMapper postResponseMapper;
    private static final Logger LOG = LoggerFactory.getLogger(PostService.class);


    PostService(
            PostRepository postRepository,
            PostMapper postMapper,
            PostResponseMapper postResponseMapper)
    {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.postResponseMapper = postResponseMapper;
    }

    public List<PostResponseDTO> getAll() {
        return postRepository.findAll()
                .stream()
                .map(postResponseMapper::toDto)
                .toList();
    }

    public PostResponseDTO getPostByTitle(String title) {
        Optional<Post> postOptional = postRepository.findOneByTitleIsLike(title);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            return postResponseMapper.toDto(post);
        }
        return null;
    }

    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
        LOG.info("CREATE POST");
        Post newPost = postMapper.toEntity(postRequestDTO);
        newPost.setCreated_date(Instant.now());
        newPost.setCreatedBy("ADMIN");
        newPost = postRepository.save(newPost);
        return postResponseMapper.toDto(newPost);
    }
}
