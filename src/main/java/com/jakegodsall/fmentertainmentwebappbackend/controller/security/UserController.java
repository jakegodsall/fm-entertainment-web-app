package com.jakegodsall.fmentertainmentwebappbackend.controller.security;

import com.jakegodsall.fmentertainmentwebappbackend.payload.UserDto;
import com.jakegodsall.fmentertainmentwebappbackend.service.security.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private static final String USER_API_ENDPOINT = "/api/users";
    private static final String USER_API_ENDPOINT_ID = USER_API_ENDPOINT + "/{userId}";
    private final UserService userService;

    @GetMapping(USER_API_ENDPOINT)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping(USER_API_ENDPOINT)
    public ResponseEntity<?> createUser(
            @Valid @RequestBody UserDto userDto
    ) {
        UserDto createdUser = userService.createUser(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdUser);
    }

    @GetMapping(USER_API_ENDPOINT_ID)
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping(USER_API_ENDPOINT_ID)
    public ResponseEntity<UserDto> updateUserById(
            @RequestBody UserDto userDto,
            @PathVariable Long userId
    ) {
        UserDto updatedUser = userService.updateUserById(userDto, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping(USER_API_ENDPOINT_ID)
    public ResponseEntity<UserDto> patchUpdateUserById(
            @RequestBody UserDto userDto,
            @PathVariable Long userId
    ) {
        UserDto updatedUser = userService.patchUpdateUserById(userDto, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(USER_API_ENDPOINT_ID)
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

}
