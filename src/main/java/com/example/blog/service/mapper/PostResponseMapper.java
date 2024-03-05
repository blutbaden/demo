package com.example.blog.service.mapper;

import com.example.blog.model.Post;
import com.example.blog.service.dto.PostResponseDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Post and its Response DTO PostResponseDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PostResponseMapper extends EntityMapper<PostResponseDTO, Post> {

    default Post fromId(String id) {
        if (id == null) {
            return null;
        }
        Post post = new Post();
        post.setId(id);
        return post;
    }
}
