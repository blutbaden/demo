package com.example.blog.post.repository;

import com.example.blog.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findOneByTitleIsLike(String title);
}
