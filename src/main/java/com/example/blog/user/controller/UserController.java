package com.example.blog.user.controller;

import com.example.blog.user.service.UserService;
import com.example.blog.user.service.dto.UserRequestDTO;
import com.example.blog.user.service.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/search/first-by-name")
    public UserResponseDTO getFirstUserByName(@RequestParam(name = "query", required = true) String name) {
        return userService.getUserByName(name);
    }

    @PostMapping("/")
    public UserResponseDTO save(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

}
