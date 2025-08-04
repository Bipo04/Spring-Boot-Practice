package org.ledang.springboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ledang.springboot.dto.UserUpdateDTO;
import org.ledang.springboot.entity.User;
import org.ledang.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    @GetMapping("/me")
    public User getUserProfile() {
        return userService.getCurrentUser();
    }

    @PutMapping("/me")
    public User updateUserProfile(@Valid @RequestBody UserUpdateDTO dto) {
        return userService.updateCurrentUser(dto);
    }

}
