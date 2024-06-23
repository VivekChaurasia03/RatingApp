package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {

    // User operations
    // Create User
    User saveUser(User user);

    // Get all User
    List<User> getAllUser();

    // Get single user based on I'd
    User getUser(String userId);

    // TODO: Update
    // TODO: Delete

}
