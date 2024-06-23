package com.lcwd.rating.service.services;

import com.lcwd.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    // Create
    Rating create(Rating rating);

    // Get all Ratings
    List<Rating> getAllRatings();

    // Get all Ratings by User I'd
    List<Rating> getAllRatingsByUserId(String userId);

    // Get all Ratings by Hotel I'd
    List<Rating> getAllRatingsByHotelId(String hotelId);
}
