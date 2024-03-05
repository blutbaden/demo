package com.example.blog.post.service.mapper;

import com.example.blog.post.model.Post;
import com.example.blog.post.service.dto.PostRequestDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Post and its DTO PostRequestDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PostMapper extends EntityMapper<PostRequestDTO, Post> {
}
