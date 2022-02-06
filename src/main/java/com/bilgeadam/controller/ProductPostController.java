package com.bilgeadam.controller;

import com.bilgeadam.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Log4j2
public class ProductPostController {

    //http://localhost:8090/controller/post
    //Gönderilecek yer
    @GetMapping("/controller/post")
    @ResponseBody
    public String redirectPost() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("post adı").productTrade("post trade").build();
        String url = "http://localhost:8090/post/basic";
        RestTemplate restTemplate = new RestTemplate();
        //karşı tarafta: Void var
        restTemplate.postForObject(url, productDto, Void.class);
        return "Tamamdır";
    }


    //http://localhost:8090/controller/post/dto?product_name=yeniadı&product_trade=yenitrade
    //Gönderilecek yer
    @GetMapping("/controller/post/dto")
    @ResponseBody
    public String redirectPostDto(
            @RequestParam(name = "product_name") String productName44,
            @RequestParam(name = "product_trade") String productTrade44
    ) {
        ProductDto productDto = ProductDto.builder().productId(0L).productName(productName44).productTrade(productTrade44).build();
        String url = "http://localhost:8090/post/object";
        RestTemplate restTemplate = new RestTemplate();
        //karşı tarafta: ProductDto var
        ProductDto productDto2 = restTemplate.postForObject(url, productDto, ProductDto.class);
        return "Tamamdır Dto" + productDto2;
    }


    //ResponseEntity
    //http://localhost:8090/controller/post/responseentity/dto?product_name=yeniadı&product_trade=yenitrade
    //Gönderilecek yer
    @GetMapping("/controller/post/responseentity/dto")
    @ResponseBody
    public String redirectPostResponseEntityDto(
            @RequestParam(name = "product_name") String productName44,
            @RequestParam(name = "product_trade") String productTrade44
    ) {
        ProductDto prod = ProductDto.builder().productId(0L).productName(productName44).productTrade(productTrade44).build();
        String URL = "http://localhost:8090/post/object";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ProductDto> requestHttpEntity = new HttpEntity<ProductDto>(prod);
        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestHttpEntity, ProductDto.class);
        ProductDto productDto2 = responseEntity.getBody();
        return "Tamamdır HttpEnttity gelen hatayı almak için:" + productDto2;
    }

}
