package com.authtokendemo.controller;

import com.authtokendemo.exception.AuthenticationException;
import com.authtokendemo.model.User;
import com.authtokendemo.model.dto.UserLoginDto;
import com.authtokendemo.model.dto.UserRegistrationDto;
import com.authtokendemo.model.dto.UserResponseDto;
import com.authtokendemo.security.AuthenticationService;
import com.authtokendemo.security.jwt.JwtTokenProvider;
import com.authtokendemo.service.mapper.UserMapper;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper, JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegistrationDto userRequestDto) {
        User user = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userMapper.mapToDto(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authenticationService.login(userLoginDto.getEmail(),
                userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail());
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
