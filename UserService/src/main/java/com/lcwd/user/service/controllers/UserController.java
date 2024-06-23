package com.lcwd.user.service.controllers;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Get single user based on I'd
    /* Implement a functionality to retrieve all the ratings
    given by the user and which rating belongs to which Hotel */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // Get all User
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> listOfUsers = userService.getAllUser();
        return ResponseEntity.ok(listOfUsers);
    }

    // TODO: Controller for Update
    // TODO: Controller for Delete
}
