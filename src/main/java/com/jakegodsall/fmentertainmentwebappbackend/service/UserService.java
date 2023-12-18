package com.jakegodsall.fmentertainmentwebappbackend.service;

import com.jakegodsall.fmentertainmentwebappbackend.payload.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    UserDto updateUser(UserDto userDto, Long id);

    Void deleteUser(Long id);

}
