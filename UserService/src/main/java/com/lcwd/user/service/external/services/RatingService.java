package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    // Below methods are confirmed using TestCases

    // Get Rating - This we have already implemented using RestTemplate

    // Post Rating - Making a post request from UserService to RatingService by calling the specific controller method
    @PostMapping("/ratings")
    public Rating createRating(Rating rating);

    // Put Rating - Making a put request from UserService - Method not creating in RatingService
    /*
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);
     */

    // Delete Rating
    /*
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
     */
}
