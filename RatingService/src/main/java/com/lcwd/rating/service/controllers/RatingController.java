package com.lcwd.rating.service.controllers;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // Create
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating givenRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(givenRating);
    }

    // Get all Ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> listOfRatings = ratingService.getAllRatings();
        return ResponseEntity.ok(listOfRatings);
    }

    // Get all Ratings by User I'd
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId) {
        List<Rating> listOfRatingsGivenByUser = ratingService.getAllRatingsByUserId(userId);
        return ResponseEntity.ok(listOfRatingsGivenByUser);
    }

    // Get all Ratings by Hotel I'd
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId) {
        List<Rating> listOfRatingsGivenToHotel = ratingService.getAllRatingsByHotelId(hotelId);
        return ResponseEntity.ok(listOfRatingsGivenToHotel);
    }
}
