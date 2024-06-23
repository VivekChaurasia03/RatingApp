package com.lcwd.rating.service.repositories;

import com.lcwd.rating.service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    // Custom finder methods - Response DataType + thing we want to perform using the userId (in camelcase)

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
