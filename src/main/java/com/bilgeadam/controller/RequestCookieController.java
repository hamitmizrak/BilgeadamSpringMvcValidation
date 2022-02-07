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
public class RequestCookieController {



    // Amac buradan Cookie olustur @RestController gitsin ve gelirken @Controllerdan göstersin
    // http://localhost:8090/controller/cookie/header
    @GetMapping("/controller/cookie/header")
    @ResponseBody
    public String getCookieController() {
        String URL = "http://localhost:8090//rest/cookie";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.COOKIE, "key_cookie=cookieValue");
        HttpEntity<String> entity = new HttpEntity<String>("diğer taraf bunu yazıyı almayacak", httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
        String body = response.getBody();
        return "@Controller Cookie " + body;
    }

}
