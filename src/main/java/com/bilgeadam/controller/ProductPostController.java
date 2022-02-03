package com.bilgeadam.controller;
import com.bilgeadam.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Log4j2
public class ProductPostController {

    //http://localhost:8090/controller/post
    //Gönderilecek yer
    @GetMapping("/controller/post")
    @ResponseBody
    public String redirectPost(){
        ProductDto productDto= ProductDto.builder().productId(0L).productName("post adı").productTrade("post trade").build();
        String url="http://localhost:8090/post/basic";
        RestTemplate restTemplate=new RestTemplate();
        //karşı tarafta: Void var
        restTemplate.postForObject(url,productDto,Void.class);
        return "Tamamdır";
    }

}
