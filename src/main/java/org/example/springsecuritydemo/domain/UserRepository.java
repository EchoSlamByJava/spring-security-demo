package org.example.springsecuritydemo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    User findByEmail(String email);

    User deleteByEmail(String email);

    boolean existsByEmail(String email);

}
