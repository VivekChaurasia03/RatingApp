package com.lcwd.user.service.repositories;

import com.lcwd.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // Custom implementations to be developed
}
