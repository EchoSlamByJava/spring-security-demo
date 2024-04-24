package org.example.springsecuritydemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
@AllArgsConstructor
public class HomeController {

    @GetMapping
    public RedirectView home() {
        return new RedirectView("/api-docs");
    }
}
