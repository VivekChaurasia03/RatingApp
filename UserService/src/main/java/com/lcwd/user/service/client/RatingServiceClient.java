package com.lcwd.user.service.client;

import com.lcwd.user.service.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RatingServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public RatingServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Rating> getRatingsForUser(String userId) {
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + userId, Rating[].class);
        assert ratingsOfUser != null;
        return Arrays.asList(ratingsOfUser);
    }
}
