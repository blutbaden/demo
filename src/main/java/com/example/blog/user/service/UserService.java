package com.example.blog.user.service;

import com.example.blog.user.model.User;
import com.example.blog.user.repository.UserRepository;
import com.example.blog.user.service.dto.UserRequestDTO;
import com.example.blog.user.service.dto.UserResponseDTO;
import com.example.blog.user.service.mapper.UserMapper;
import com.example.blog.user.service.mapper.UserResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceExternal, UserServiceInternal {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserResponseMapper userResponseMapper;
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);


    UserService(
            UserRepository userRepository,
            UserMapper userMapper,
            UserResponseMapper userResponseMapper)
    {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userResponseMapper = userResponseMapper;
    }

    public List<UserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userResponseMapper::userToUserResponseDTO)
                .toList();
    }

    public UserResponseDTO getUserByName(String name) {
        Optional<User> userOptional = userRepository.findOneByNameIsLike(name);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return userResponseMapper.userToUserResponseDTO(user);
        }
        return null;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        LOG.info("CREATE USER");
        User newUser = userMapper.userRequestDTOToUser(userRequestDTO);
        newUser.setCreated_date(Instant.now());
        newUser.setCreatedBy("ADMIN");
        newUser = userRepository.save(newUser);
        return userResponseMapper.userToUserResponseDTO(newUser);
    }
}
