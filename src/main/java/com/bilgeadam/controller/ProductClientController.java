package com.bilgeadam.controller;

import com.bilgeadam.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@Log4j2
public class ProductClientController {

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

    //getForObject
    // http://localhost:8090/client/controller/pathvariable/productdto/denemeurun
    @GetMapping("/client/controller/pathvariable/productdto/{urun_adi}")
    @ResponseBody
    public ProductDto getProductServicesObject(@PathVariable("urun_adi") String urunAdim44) {
        String URL = "http://localhost:8090/rest/pathvariable/"+urunAdim44;
        // restten veri almak istiyorsam;
        RestTemplate restTemplate=new RestTemplate();
        ProductDto productDto= restTemplate.getForObject(URL, ProductDto.class);
        return  productDto;
    }


    //ResponseEntity
    // http://localhost:8090/client/controller/pathvariable/productdto/special/denemeurun66
    @GetMapping("/client/controller/pathvariable/productdto/special/{urun_adi}")
    @ResponseBody
    public ProductDto getProductServicesSupLevel(@PathVariable("urun_adi") String urunAdim44) {
        String URL = "http://localhost:8090/rest/pathvariable/"+urunAdim44;
        // restten veri almak istiyorsam;
        RestTemplate restTemplate=new RestTemplate();
        ProductDto productDto= restTemplate.getForObject(URL, ProductDto.class);
        ResponseEntity<ProductDto> responseEntity= restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY,ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return productDto2;
    }


    //ResponseEntity ==> List
    // http://localhost:8090/client/controller/pathvariable/productdto/specialList/denemeurun66
    @GetMapping("/client/controller/pathvariable/productdto/specialList/{urun_adi}")
    @ResponseBody
    public  List<ProductDto> getProductServicesSupLevelList(@PathVariable("urun_adi") String urunAdim44) {
        String URL = "http://localhost:8090/rest/pathvariablelist/"+urunAdim44;
        RestTemplate restTemplate=new RestTemplate();
        //anonymous class
        ResponseEntity<List<ProductDto>> responseEntity= restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ProductDto>>() {
        });
        List<ProductDto> productDtoList=responseEntity.getBody();
        for(ProductDto temp: productDtoList){
            System.out.println(temp);
        }
        return productDtoList;   // ""+productDtoList.size();
    }


    //güncellemek
    // http://localhost:8090/put?product_name=urunadi55&product_trade=msi
    @GetMapping("/put")
    @ResponseBody
    public String  getProductPutl(
            @RequestParam(name = "product_name")  String productName,
            @RequestParam(name = "product_trade") String productTrade
            ) {
        ProductDto productDto1=ProductDto.builder().productId(0L).productTrade(productTrade).productName(productName).build();
        String URL = "http://localhost:8090/put/object/";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<ProductDto> responseEntity= restTemplate.exchange(URL, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto1) ,ProductDto.class);
        ProductDto productDto2=responseEntity.getBody();
        return productDto2+"";
    }


    //silmek
    // http://localhost:8090/delete/1
    @GetMapping("/delete/{id}")
    @ResponseBody
    public String  getProductPutl(@PathVariable(name = "id")  Long id) {
        String URL = "http://localhost:8090/delete/"+id;
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.exchange(URL, HttpMethod.DELETE, HttpEntity.EMPTY ,Void.class);
        return "Service Silindi .";
    }


    //////////////////////////
    //MEDIA TYPE XML
    //ResponseEntity ==> List
    // http://localhost:8090/client/xml
    @GetMapping("/client/xml")
    @ResponseBody
    public  List<ProductDto> getXmlProductList() {
        String URL = "http://localhost:8090/rest/xml";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<List<ProductDto>> responseEntity= restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ProductDto>>() {
        });
        List<ProductDto> productDtoList=responseEntity.getBody();
        for(ProductDto temp: productDtoList){
            System.out.println(temp);
        }
        return productDtoList;   // ""+productDtoList.size();
    }

}
