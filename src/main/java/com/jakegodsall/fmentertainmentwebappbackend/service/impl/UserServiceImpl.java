package com.jakegodsall.fmentertainmentwebappbackend.service.impl;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByIdException;
import com.jakegodsall.fmentertainmentwebappbackend.mapper.UserMapper;
import com.jakegodsall.fmentertainmentwebappbackend.payload.UserDto;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.UserRepository;
import com.jakegodsall.fmentertainmentwebappbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::userToUserDto)
                .toList();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // Create a user entity from DTO
        User user = UserMapper.userDtoToUser(userDto);

        // Save the entity to the db
        User savedUser = userRepository.save(user);

        // Map the saved user entity to DTO and return
        return UserMapper.userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        // Get the user from the db
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("User", id)
        );

        // Map the user to DTO and return
        return UserMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        // Create an updated user object
        User user = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getPassword())
                .roles(userDto.getRoles())
                .build();

        // Save the updated user to the database
        User updatedUser = userRepository.save(user);

        // Map saved user entity to DTO and return
        return UserMapper.userToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        // Get the entity from the database
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("User", id)
        );

        // Delete the entity
        userRepository.delete(user);
    }
}
