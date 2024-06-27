package com.lcwd.user.service;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Supplier;

@SpringBootTest
class UserServiceApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(UserServiceApplicationTests.class);

	@Test
	void contextLoads() {
	}

	/*
	@Autowired
	private RatingService ratingService;

	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using Feign client").build();
		Rating savedRating = ratingService.createRating(rating);
		logger.info(String.valueOf(savedRating));
	}
	 */

}
