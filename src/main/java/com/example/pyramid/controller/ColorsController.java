package com.example.pyramid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorsController {

    @GetMapping("/list")
    public List<String> getColors() {
        System.out.println("Inside Colors controller");
        return List.of("Red", "Blue", "Green", "Yellow", "Purple");
    }
}
