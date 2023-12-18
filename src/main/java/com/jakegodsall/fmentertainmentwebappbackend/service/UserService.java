package com.jakegodsall.fmentertainmentwebappbackend.service;

import com.jakegodsall.fmentertainmentwebappbackend.payload.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    UserDto updateUserById(UserDto userDto, Long id);

    void deleteUserById(Long id);

}
