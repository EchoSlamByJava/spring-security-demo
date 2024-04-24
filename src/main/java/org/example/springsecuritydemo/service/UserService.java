package org.example.springsecuritydemo.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.springsecuritydemo.domain.User;
import org.example.springsecuritydemo.domain.UserRepository;
import org.example.springsecuritydemo.exception.EmailAlreadyExistsException;
import org.example.springsecuritydemo.exception.UserNotFoundException;
import org.example.springsecuritydemo.security.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public User getByEmail(String email) throws UserNotFoundException {
        var user = repository.findByEmail(email);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException("User with email " + email + " not found");
    }

    public User create(User user) throws EmailAlreadyExistsException {
        if (repository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }
        if (user.getUid() == null) {
            user.setUid(UUID.randomUUID());
        }
        return this.save(user);
    }

    public User deleteByEmail(String email) {
        return repository.deleteByEmail(email);
    }

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    private User save(User user) {
        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    @SneakyThrows
    public UserDetailsService userDetailsService () {
        return this::getByEmail;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() throws UserNotFoundException {
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByEmail(email);
    }

    /**
     * Выдача прав администратора текущему пользователю
     * <p>
     * Нужен для демонстрации
     */
    public void getAdmin() throws UserNotFoundException {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        this.save(user);
    }
}
