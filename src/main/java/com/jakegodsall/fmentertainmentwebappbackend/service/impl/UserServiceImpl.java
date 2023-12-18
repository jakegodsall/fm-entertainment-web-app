package com.jakegodsall.fmentertainmentwebappbackend.service.impl;

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
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        return null;
    }

    @Override
    public Void deleteUser(Long id) {
        return null;
    }
}
