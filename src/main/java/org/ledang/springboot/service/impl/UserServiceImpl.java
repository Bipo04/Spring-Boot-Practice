package org.ledang.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.ledang.springboot.dto.UserCreateDTO;
import org.ledang.springboot.dto.UserUpdateDTO;
import org.ledang.springboot.entity.User;
import org.ledang.springboot.repository.UserRepository;
import org.ledang.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    public User addUser(UserCreateDTO dto) {
        User userToAdd = new User();
        userToAdd.setUsername(dto.getUsername());
        userToAdd.setPassword(dto.getPassword());
        userToAdd.setEmail(dto.getEmail());
        userToAdd.setFullName(dto.getFullName());
        userToAdd.setPhone(dto.getPhone());
        return userRepository.save(userToAdd);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public User updateUser(Long id, UserUpdateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }
}
