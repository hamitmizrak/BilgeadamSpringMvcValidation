package com.bilgeadam.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHeaderServices {

    //requestHeader: ben header içine bir data gönderiyorum
    // http://localhost:8090/rest/header
    @GetMapping("/rest/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "key_header", defaultValue = "default header") String data) {
        //key_gidecek: karşı tarafla haberleşmeyi sağlayacak yer
        String headerData = "@RestController geldiğinin kanıtı: " + data;
        System.out.println(headerData);
        return ResponseEntity.ok(headerData);
    }


    //requestHeader: ben header içine bir data gönderiyorum
    // http://localhost:8090/rest/cookie
    @GetMapping("/rest/cookie")
    public ResponseEntity<?> getCookie(@CookieValue(value = "key_cookie", defaultValue = "default cookie") String data) {
        String headerData = "@RestController geldiğinin kanıtı: " + data;
        System.out.println(headerData);
        return ResponseEntity.ok(headerData);
    }
}
