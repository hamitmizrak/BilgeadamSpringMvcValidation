package com.bilgeadam.controller;

import com.bilgeadam.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

@Controller
public class ProductController {
    private final static String URL = "http://localhost:8090/rest/pathvariablelist/";


    ////CLIENT
    // http://localhost:8090/client/controller/string
    @GetMapping("/client/controller/string")
    @ResponseBody
    public String getProductServicesString() {
        //NOT: http eklemelisin
        String URL = "http://localhost:8090/rest/manueljson/";

       // restten veri almak istiyorsam;
        RestTemplate restTemplate=new RestTemplate();
        String jsonData= restTemplate.getForObject(URL,String.class);
        return "veriler44:"+ jsonData;
    }



    // http://localhost:8090/client/controller/productdto
    @GetMapping("/client/controller/productdto")
    @ResponseBody
    public String getProductServicesObject() {
        String URL = "http://localhost:8090/rest/dynamicjson/";

        // restten veri almak istiyorsam;
        RestTemplate restTemplate=new RestTemplate();
        ProductDto productDto= restTemplate.getForObject(URL, ProductDto.class);
        return "veriler44:"+ productDto;
    }


    // http://localhost:8090/client/controller/pathvariable/productdto/denemeurun
    @GetMapping("/client/controller/pathvariable/productdto/{urun_adi}")
    @ResponseBody
    public String getProductServicesObject(@PathVariable("urun_adi") String urunAdim44) {
        String URL = "http://localhost:8090/rest/pathvariable/"+urunAdim44;

        // restten veri almak istiyorsam;
        RestTemplate restTemplate=new RestTemplate();
        ProductDto productDto= restTemplate.getForObject(URL, ProductDto.class);
        return "veriler55:"+ productDto;
    }
}
