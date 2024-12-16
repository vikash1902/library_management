package com.example.pyramid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FruitController {

    @GetMapping("/getFruits")
    public List<String> getFruits() {
        System.out.println("Inside Fruits controller");
        return List.of("Apple", "Banana", "Mango", "Pineapple", "Grapes");
    }
}
