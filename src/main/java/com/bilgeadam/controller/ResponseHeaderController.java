package com.bilgeadam.controller;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ResponseHeaderController {
    // bu sefer gönderen taraf burası :
    // http://localhost:8090/controller/response/header
    @GetMapping("/controller/response/header")
    @ResponseBody
    public String getHeaderResponseController() {
        String URL = "http://localhost:8090/restcontroller/response/header";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String gelenData = response.getHeaders().getFirst("key_response");
        String body = response.getBody();
        return "@Controller " + body + " " + gelenData;
    }
}
