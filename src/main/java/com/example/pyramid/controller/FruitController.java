package com.example.pyramid.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FruitController {

    @PreAuthorize("hasRole('PUBLIC')")
    @GetMapping("/getFruits")
    @SecurityRequirement(name = "bearerAuth")
    public List<String> getFruits() {
        System.out.println("Inside Fruits controller");
        return List.of("Apple", "Banana", "Mango", "Pineapple", "Grapes");
    }
}
