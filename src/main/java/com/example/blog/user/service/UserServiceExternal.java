package com.example.blog.user.service;

import com.example.blog.user.service.dto.UserRequestDTO;
import com.example.blog.user.service.dto.UserResponseDTO;

import java.util.List;

public interface UserServiceExternal {
    List<UserResponseDTO> getAll();
    UserResponseDTO getUserByName(String name);
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
