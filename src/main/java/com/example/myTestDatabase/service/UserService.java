package com.example.myTestDatabase.service;

import com.example.myTestDatabase.controller.request.UserCreateRequest;
import com.example.myTestDatabase.model.User;
import com.example.myTestDatabase.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateRequest request) {
        if(userRepository.findByEmail(request.email)==null)
        {
            User user = new User(request.email, request.name);
            return userRepository.save(user);
        }else {
            System.out.println("The user already exists!");
            return null;
        }
    }

    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        userRepository.delete(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(String email, UserCreateRequest request) {
        User user = userRepository.findByEmail(email);
        user.setEmail(request.email);
        user.setName(request.name);
        return userRepository.save(user);
    }
}
