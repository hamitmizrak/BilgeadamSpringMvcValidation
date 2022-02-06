package com.bilgeadam.services;

import com.bilgeadam.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ProductPostServices {

    /////POST
    //Alıncak yer  alınıcak
    // http://localhost:8090/post/basic
    @PostMapping("/post/basic")
    public void postProduct(@RequestBody ProductDto productDto) {
        log.info(productDto);
    }


    /////POST :eklemek
    // http://localhost:8090/post/object
    @PostMapping("/post/object")
    public ProductDto postProductObject(@RequestBody ProductDto productDto) {
        log.info("eklemek "+productDto);
        return productDto;
    }

    ////PUT: guncellemek
    // id=0  ==> eklemek
    // id!=0 ==> güncellemek
    // http://localhost:8090/put/object
    @PutMapping("/put/object")
    public ProductDto putProductObject(@RequestBody ProductDto productDto) {
        log.info("güncellemek"+productDto);
        return productDto;
    }



}
