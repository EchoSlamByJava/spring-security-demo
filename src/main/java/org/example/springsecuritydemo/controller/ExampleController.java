package org.example.springsecuritydemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/example")
@Tag(name = "Пример контроллера для разных ролей")
public class ExampleController {

    @GetMapping
    @Operation(summary = "Доступен только авторизованным пользователям")
    public String example(Authentication authentication) {
        var userDetails =  (UserDetails) authentication.getPrincipal();
        return "Hello, world! by " + userDetails.getUsername();
    }
}
