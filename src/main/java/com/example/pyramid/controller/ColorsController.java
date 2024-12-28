package com.example.pyramid.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorsController {

    @GetMapping("/list")
    @SecurityRequirement(name = "bearerAuth")
    public List<String> getColors() {
        System.out.println("Inside Colors controller");
        return List.of("Red", "Blue", "Green", "Yellow", "Purple");
    }
}
