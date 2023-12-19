package com.jakegodsall.fmentertainmentwebappbackend.mapper;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import com.jakegodsall.fmentertainmentwebappbackend.payload.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto userToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .version(user.getVersion())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }

    public static User userDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .version(userDto.getVersion())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .roles(userDto.getRoles())
                .build();
    }
}
