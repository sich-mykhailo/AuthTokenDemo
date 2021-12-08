package com.authtokendemo.service.mapper;

import com.authtokendemo.model.User;
import com.authtokendemo.model.dto.UserRegistrationDto;
import com.authtokendemo.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToModel(UserRegistrationDto requestDto) {
        User user = new User();
        user.setPassword(requestDto.getPassword());
        user.setEmail(requestDto.getEmail());
        return user;
    }

    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setEmail(user.getEmail());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }
}
