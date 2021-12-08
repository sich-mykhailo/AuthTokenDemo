package com.authtokendemo.controller;

import com.authtokendemo.model.User;
import com.authtokendemo.model.dto.UserRegistrationDto;
import com.authtokendemo.model.dto.UserResponseDto;
import com.authtokendemo.service.UserService;
import com.authtokendemo.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.findAll()
                .stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRegistrationDto dto) {
        User user = userService.save(userMapper.mapToModel(dto));
        return userMapper.mapToDto(user);
    }

}
