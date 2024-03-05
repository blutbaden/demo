package com.example.blog.user.service.mapper;

import com.example.blog.user.model.User;
import com.example.blog.user.service.dto.UserRequestDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Post and its DTO PostRequestDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
    UserRequestDTO userToUserRequestDTO(User user);
    User userRequestDTOToUser(UserRequestDTO userRequestDTO);
}
