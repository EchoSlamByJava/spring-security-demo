package org.example.springsecuritydemo.controller;

import lombok.AllArgsConstructor;
import org.example.springsecuritydemo.domain.User;
import org.example.springsecuritydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/get/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User deleteUserByEmail(@PathVariable String email) {
        return userService.deleteByEmail(email);
    }

}
