package com.example.pyramid.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/hello")
    public String home() {
        return "home"; // Maps to src/main/resources/templates/home.html (Thymeleaf)
    }
}
