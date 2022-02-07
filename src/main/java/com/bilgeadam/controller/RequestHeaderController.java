package com.bilgeadam.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RequestHeaderController {

    // Amac buradan Header olustur @RestController gitsin ve gelirken @Controllerdan göstersin
    // http://localhost:8090/controller/clie    nt/header
    @GetMapping("/controller/client/header")
    @ResponseBody
    public String getHeaderController() {
        String URL = "http://localhost:8090/rest/header";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("key_header", "headerValue");
        HttpEntity<String> entity = new HttpEntity<String>("diğer taraf bunu yazıyı almayacak", httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
        String body = response.getBody();
        return "@Controller " + body;
    }



}
