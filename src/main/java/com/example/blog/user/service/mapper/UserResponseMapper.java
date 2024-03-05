package com.example.blog.user.service.mapper;

import com.example.blog.user.model.User;
import com.example.blog.user.service.dto.UserResponseDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Post and its Response DTO PostResponseDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserResponseMapper {
    UserResponseDTO userToUserResponseDTO(User user);
    User userResponseDTOToUser(UserResponseDTO userResponseDTO);
}
