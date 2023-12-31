package com.jakegodsall.fmentertainmentwebappbackend.service.security.impl;

import com.jakegodsall.fmentertainmentwebappbackend.entity.security.Role;
import com.jakegodsall.fmentertainmentwebappbackend.entity.security.User;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByIdException;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByNameException;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.UniqueEntityFieldAlreadyTakenException;
import com.jakegodsall.fmentertainmentwebappbackend.mapper.UserMapper;
import com.jakegodsall.fmentertainmentwebappbackend.payload.security.UserDto;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.RoleRepository;
import com.jakegodsall.fmentertainmentwebappbackend.repository.security.UserRepository;
import com.jakegodsall.fmentertainmentwebappbackend.service.security.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
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
        // Check if username already exists
        if (!isUsernameAvailable(userDto.getUsername()))
            throw new UniqueEntityFieldAlreadyTakenException("Username", userDto.getUsername());

        if (!isEmailAvailable(userDto.getEmail()))
            throw new UniqueEntityFieldAlreadyTakenException("Email", userDto.getEmail());


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

        // Update last modified date to now
        userFromDb.setLastModifiedDate(LocalDateTime.now());

        // Update fields with values from DTO
        userFromDb.setUsername(userDto.getUsername());
        userFromDb.setPassword(userDto.getPassword());
        userFromDb.setEmail(userDto.getEmail());
        userFromDb.setRoles(userDto.getRoles());

        // Save the updated user to the database
        User updatedUser = userRepository.save(userFromDb);

        // Map saved user entity to DTO and return
        return UserMapper.userToUserDto(updatedUser);
    }

    @Transactional
    @Override
    public UserDto patchUpdateUserById(UserDto userDto, Long userId) {
        // Get the user from the db
        User userFromDb = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundByIdException("User", userId)
        );

        // Update fields if field exists in DTO
        if (StringUtils.hasText(userDto.getUsername()))
            userFromDb.setUsername(userDto.getUsername());

        if (StringUtils.hasText(userDto.getEmail()))
            userFromDb.setEmail(userDto.getEmail());

        if (StringUtils.hasText(userDto.getPassword()))
            userFromDb.setPassword(userDto.getPassword());

        // Save the updated user to the database
        User savedUser = userRepository.save(userFromDb);

        // Map saved user entity to DTO and return
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

    private boolean isUsernameAvailable(String username) {
        return !userRepository.existsByUsername(username);
    }

    private boolean isEmailAvailable(String email) {
        return !userRepository.existsByEmail(email);
    }
}
