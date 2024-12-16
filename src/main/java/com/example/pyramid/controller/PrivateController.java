package com.example.pyramid.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {


    @PreAuthorize("hasRole('PUBLIC')")
    @PostMapping("/name")
    public ResponseEntity<String> fetchName(){
        return new ResponseEntity<>("Hello i am robert, a admin user", HttpStatusCode.valueOf(200));
    }


    @PreAuthorize("hasRole('PUBLIC')")
    @PostMapping("/nameq")
    public ResponseEntity<String> fetchNameQ(){
        return new ResponseEntity<>("Hello i am robert, a public user", HttpStatusCode.valueOf(200));
    }
}
