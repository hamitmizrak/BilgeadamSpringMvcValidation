package com.bilgeadam.services;

import com.bilgeadam.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
public class ResponseServices {

    // http://localhost:8090/rest/status1/ok
    @GetMapping("/rest/status1/ok")
    public ResponseEntity<ProductDto> getStatus1() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Bilgisayar").productTrade("marka").build();
        //                 (body,status)
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }


    // http://localhost:8090/rest/status2/ok
    @GetMapping("/rest/status2/ok")
    public ResponseEntity<ProductDto> getStatus2() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Bilgisayar").productTrade("marka").build();
        //ResponseEntity.status().body()
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    // http://localhost:8090/rest/status3/ok
    @GetMapping("/rest/status3/ok")
    public ResponseEntity<ProductDto> getStatus3() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Bilgisayar").productTrade("marka").build();
        //ok().body()
        return ResponseEntity.ok().body(productDto);
    }


    // http://localhost:8090/rest/status4/ok
    @GetMapping("/rest/status4/ok")
    public ResponseEntity<ProductDto> getStatus4() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Bilgisayar").productTrade("marka").build();
        //ok içinde body
        return ResponseEntity.ok(productDto);
    }


    ////NOTFOUND////
    //?
    // http://localhost:8090/rest/status5/notfound/44
    @GetMapping("/rest/status5/notfound/{id}")
    public ResponseEntity<?> getStatus5(@PathVariable("id") Long id) {
        ProductDto productDto = ProductDto.builder().productId(id).productName("Bilgisayar").productTrade("marka").build();
        if (productDto.getProductId() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt bulunamadı");
        }
        return ResponseEntity.ok(productDto);
    }



    //404=notfound hatası vermek
    // http://localhost:8090/rest/status6/notfound/44
    @GetMapping("/rest/status6/notfound/{id}")
    public ResponseEntity<?> getStatus6(@PathVariable("id") Long id) {
        ProductDto productDto = ProductDto.builder().productId(id).productName("Bilgisayar").productTrade("marka").build();
        if (productDto.getProductId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDto);
    }


    //400=bad request hatası vermek
    // http://localhost:8090/rest/status7/notfound/44
    @GetMapping("/rest/status7/notfound/{id}")
    public ResponseEntity<?> getStatus7(@PathVariable("id") Long id) {
        ProductDto productDto = ProductDto.builder().productId(id).productName("Bilgisayar").productTrade("marka").build();
        if (productDto.getProductId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productDto);
    }

    //Dikkat çalışmıyor
    //400=bad request hatası vermek
    // http://localhost:8090/rest/status8/notfound/44
    @GetMapping("/rest/status8/notfound/{id}")
    public ResponseEntity<?> getStatus8(@PathVariable("id") Long id) {
        ProductDto productDto = ProductDto.builder().productId(id).productName("Bilgisayar").productTrade("marka").build();
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK).contentType(new MediaType("application","json", Charset.forName("UTF-8")));
    }


}
