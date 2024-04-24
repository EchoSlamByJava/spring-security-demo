package org.example.springsecuritydemo.service;

import lombok.AllArgsConstructor;
import org.example.springsecuritydemo.domain.User;
import org.example.springsecuritydemo.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User create(User user) {
        if (user.getUid() == null) {
            user.setUid(UUID.randomUUID());
        }
        return repository.save(user);
    }

    public User deleteByEmail(String email) {
        return repository.deleteByEmail(email);
    }

    public List<User> getAll() {
        return repository.findAll();
    }
}
