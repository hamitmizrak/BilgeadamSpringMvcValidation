package com.bilgeadam.services;

import com.bilgeadam.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
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


}
