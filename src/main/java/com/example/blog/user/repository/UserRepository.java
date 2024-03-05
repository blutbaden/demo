package com.example.blog.user.repository;

import com.example.blog.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findOneByNameIsLike(String name);
}
