package com.example.blog.service.mapper;

import com.example.blog.model.Post;
import com.example.blog.service.dto.PostRequestDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Post and its DTO PostRequestDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PostMapper extends EntityMapper<PostRequestDTO, Post> {

    default Post fromId(String id) {
        if (id == null) {
            return null;
        }
        Post post = new Post();
        post.setId(id);
        return post;
    }
}
