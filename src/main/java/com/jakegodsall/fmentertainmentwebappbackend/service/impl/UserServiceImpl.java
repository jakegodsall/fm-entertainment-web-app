package com.jakegodsall.fmentertainmentwebappbackend.service.impl;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByIdException;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByNameException;
import com.jakegodsall.fmentertainmentwebappbackend.mapper.UserMapper;
import com.jakegodsall.fmentertainmentwebappbackend.payload.UserDto;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.RoleRepository;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.UserRepository;
import com.jakegodsall.fmentertainmentwebappbackend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::userToUserDto)
                .toList();
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        // Create a user entity from DTO
        User user = UserMapper.userDtoToUser(userDto);

        // Get the user role from the database
        Role defaultUserRole = roleRepository.findByName("USER").orElseThrow(
                () -> new ResourceNotFoundByNameException("Role", "name", "USER")
        );

        System.out.println("UserDto" + userDto);

        user.setRoles(new HashSet<>());
        user.getRoles().add(defaultUserRole);

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

    @Transactional
    @Override
    public UserDto updateUserById(UserDto userDto, Long id) {
        // Get the user from the db
        User userFromDb = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("User", id)
        );

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
    public UserDto patchUpdateUserById(UserDto userDto, Long userId) {
        User userFromDb = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundByIdException("User", userId)
        );

        if (StringUtils.hasText(userDto.getUsername()))
            userFromDb.setUsername(userDto.getUsername());

        if (StringUtils.hasText(userDto.getEmail()))
            userFromDb.setEmail(userDto.getEmail());

        if (StringUtils.hasText(userDto.getPassword()))
            userFromDb.setPassword(userDto.getPassword());

        User savedUser = userRepository.save(userFromDb);

        return UserMapper.userToUserDto(savedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        // Get the entity from the database
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("User", id)
        );

        // Delete the entity
        userRepository.delete(user);
    }
}
