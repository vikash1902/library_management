package com.example.pyramid.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/hello")
    @SecurityRequirement(name = "bearerAuth")
    public String home() {
        return "home"; // Maps to src/main/resources/templates/home.html (Thymeleaf)
    }
}
