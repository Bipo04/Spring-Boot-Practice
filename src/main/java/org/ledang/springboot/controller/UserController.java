package org.ledang.springboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ledang.springboot.dto.UserCreateDTO;
import org.ledang.springboot.dto.UserUpdateDTO;
import org.ledang.springboot.entity.User;
import org.ledang.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    final private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User addUser(@Valid @RequestBody UserCreateDTO dto) {
        return userService.addUser(dto);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody UserUpdateDTO dto) {
        return userService.updateUser(userId, dto);
    }

}
