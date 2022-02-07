package com.bilgeadam.services;

import com.bilgeadam.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductClientServices {

    // http://localhost:8090/rest/manueljson
    @GetMapping("/rest/manueljson")
    public String getManuelJson() {
        return "{ \"adı\": \"Hamit Mızrak\"}";
    }

    // http://localhost:8090/rest/dynamicjson
    @GetMapping("/rest/dynamicjson")
    public ProductDto getDynamicsJson() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Bilgisayar").productTrade("marka").build();
        return productDto;
    }

    // http://localhost:8090/rest/produces
    @GetMapping(value = "/rest/produces", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getProduces() {
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Bilgisayar2").productTrade("marka2").build();
        return productDto;
    }

    // http://localhost:8090/rest/pathvariable/urunadi
    @GetMapping(value = "/rest/pathvariable/{productname}")
    public ProductDto getPathParam(@PathVariable("productname") String product_name) {
        ProductDto productDto = ProductDto.builder().productId(0L).productName(product_name).productTrade("marka3").build();
        return productDto;
    }


    // http://localhost:8090/rest/pathvariablelist/urunadi
    @GetMapping(value = "/rest/pathvariablelist/{productname}")
    public List<ProductDto> getPathParamList(@PathVariable("productname") String product_name) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName(product_name).productTrade("marka4").build());
        productDtoList.add(ProductDto.builder().productId(0L).productName(product_name).productTrade("marka44").build());
        productDtoList.add(ProductDto.builder().productId(0L).productName(product_name).productTrade("marka444").build());
        return productDtoList;
    }

    //////////////////////////
    //MEDIA TYPE XML
    // http://localhost:8090/rest/xml
    @GetMapping(value = "/rest/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<ProductDto> getXmlList() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("product_name 1").productTrade("marka 1").build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("product_name 2").productTrade("marka 2").build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("product_name 3").productTrade("marka 3").build());
        return productDtoList;
    }


}
