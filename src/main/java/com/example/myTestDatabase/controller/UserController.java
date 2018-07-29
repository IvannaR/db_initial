package com.example.myTestDatabase.controller;

import com.example.myTestDatabase.controller.request.UserCreateRequest;
import com.example.myTestDatabase.model.User;
import com.example.myTestDatabase.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody UserCreateRequest request) {
        return service.createUser(request);
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String email) {
       service.deleteUser(email);
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @PutMapping("/update/{email}")
    public User updateUser(@PathVariable String email, @Valid @RequestBody UserCreateRequest request) {
            return service.updateUser(email,request);
    }
}
