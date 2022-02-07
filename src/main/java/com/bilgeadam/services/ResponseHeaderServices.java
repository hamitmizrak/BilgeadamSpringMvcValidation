package com.bilgeadam.services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseHeaderServices {

    //responseHeader: Burada Servistarafında Header oluşturacağım
    // http://localhost:8090/restcontroller/response/header
    @GetMapping("/restcontroller/response/header")
    public ResponseEntity<?> getResponseHeader() {
        return ResponseEntity
                .ok()
                .header("key_response", "headerValue")
                .body("service Header");
    }
}
