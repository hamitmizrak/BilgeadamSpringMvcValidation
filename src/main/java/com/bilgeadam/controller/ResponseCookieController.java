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
public class ResponseCookieController {

//
    // http://localhost:8090/controller/response/cookie/header
    @GetMapping("/controller/response/cookie/header")
    @ResponseBody
    public String getCookieController() {
        String URL = "http://localhost:8090/rest/response/cookie";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String data=response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        String body = response.getBody();
        return "@Controller ==> " + body+" "+data;
    }

}
