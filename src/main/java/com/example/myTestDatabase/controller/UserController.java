package com.example.myTestDatabase.controller;

import com.example.myTestDatabase.controller.request.UserCreateRequest;
import com.example.myTestDatabase.model.User;
import com.example.myTestDatabase.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody UserCreateRequest request) {
        User user = new User(request.email, request.name);
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String email) {
            User user = userRepository.findByEmail(email);
            userRepository.delete(user);
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
            User user =  userRepository.findByEmail(email);
        System.out.println(user);
        return user;
    }

    @PutMapping("/update/{email}")
    public User updateUser(@PathVariable String email, @Valid @RequestBody UserCreateRequest request) {
            User user = userRepository.findByEmail(email);
            user.setEmail(request.email);
            user.setName(request.name);
            return userRepository.save(user);
    }


}
