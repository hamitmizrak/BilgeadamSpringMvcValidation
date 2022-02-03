package com.bilgeadam.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServices {

    // localhost:8090/product
    @GetMapping("/product")
    public String getProducts(){
        return "{ \"adı\": \"Hamit Mızrak\"}";
    }
}
