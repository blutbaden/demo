package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findOneByTitleIsLike(String title);
}
