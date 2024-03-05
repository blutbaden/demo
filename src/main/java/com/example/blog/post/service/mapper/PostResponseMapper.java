package com.example.blog.post.service.mapper;

import com.example.blog.post.model.Post;
import com.example.blog.post.service.dto.PostResponseDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Post and its Response DTO PostResponseDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PostResponseMapper extends EntityMapper<PostResponseDTO, Post> {

}
