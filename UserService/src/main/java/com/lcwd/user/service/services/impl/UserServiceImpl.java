package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.client.HotelServiceClient;
import com.lcwd.user.service.client.RatingServiceClient;
import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RatingServiceClient ratingServiceClient;
    private final HotelServiceClient hotelServiceClient;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RatingServiceClient ratingServiceClient, HotelServiceClient hotelServiceClient) {
        this.userRepository = userRepository;
        this.ratingServiceClient = ratingServiceClient;
        this.hotelServiceClient = hotelServiceClient;
    }

    @Override
    public User saveUser(User user) {
        // Generates unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // Get user from the database
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with the given id is not found on the server. ID: " + userId));

        // Fetch ratings given by this user
        List<Rating> ratings = ratingServiceClient.getRatingsForUser(user.getUserId());

        // Fetch hotels for each rating
        List<Rating> ratingList = ratings.stream().peek(rating -> {
            Hotel hotel = hotelServiceClient.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
