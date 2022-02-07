package com.bilgeadam.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseCookieServices {


    // http://localhost:8090/rest/response/cookie
    @GetMapping("/rest/response/cookie")
    public ResponseEntity<?> getCookie() {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,"key_response_cookie")
                .body("@RestController ==> ");
    }
}
