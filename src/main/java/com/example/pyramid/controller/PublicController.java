package com.example.pyramid.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/name")
    public ResponseEntity<String> fetchName() {
        return new ResponseEntity<>("Hello i am robert", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/info")
    public  ResponseEntity<String> fetchUserInfo(@RequestParam("token") String accessToken ){
        try{
        String userInfoEndpoint = "https://www.googleapis.com/oauth2/v3/tokeninfo";
        RestTemplate restTemplate = new RestTemplate();

        // Add the access token to the request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

            return restTemplate.exchange(
                    userInfoEndpoint,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

    } catch (HttpClientErrorException e) {
        // Handle specific HTTP errors
        if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Invalid credentials.");
        }
        return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
    } catch (Exception e) {
        // Handle generic errors
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }

    }

}
