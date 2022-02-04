package com.bilgeadam.controller;

import com.bilgeadam.dto.ProductDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafList {


    //  http://localhost:8090/thymeleaf/44
    @GetMapping(path = {"/thymeleaf","/thymeleaf/{id}"}  )
    public String getThymeleaf(Model model, @PathVariable(name="id",required = false) Long id){
        ProductDto productDto;
        if(id==null){
            productDto=new ProductDto(0L,"","",0);
        }else{
            productDto=new ProductDto(44L,"product name ","product trade ",0);
        }
        model.addAttribute("message","Success !!!!");
        model.addAttribute("key",productDto);
        return "/templates6";
    }

    //http://localhost:8090/thymeleaf
    @PostMapping(path = {"/thymeleaf","/thymeleaf/{id}"}  )
    public String postThymeleaf(Model model, ProductDto productDto,  BindingResult bindingResult){
        productDto.setProductId(15L);
        System.out.println("post datası "+productDto);

        if(bindingResult.hasErrors()){
            bindingResult.addError(new ObjectError("key","Hata var"));
            return "/templates6";
        }

        model.addAttribute("message","başarılı !!!!");
        model.addAttribute("key",productDto);
        return "templates6";
    }


    //  http://localhost:8090/thymeleaf/list
    @GetMapping("/thymeleaf/list"  )
    public String getThymeleafList(Model model){
        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(new ProductDto(1L,"product adı 1","trade 1",1000));
        productDtoList.add(new ProductDto(2L,"product adı 2","trade 2",2000));
        productDtoList.add(new ProductDto(3L,"product adı 3","trade 3",3000));
        productDtoList.add(new ProductDto(4L,"product adı 4","trade 4",4000));
        model.addAttribute("thymeleaf_key_list",productDtoList);
        return "/templates7list";
    }


    //  http://localhost:8090/thymeleaf/44
    @GetMapping(path = {"/thymeleaf/delete","/thymeleaf/delete/{id}"}  )
    public String getThymeleafDelete(Model model){

        model.addAttribute("message","silindi !!!!");
        model.addAttribute("key","productDto listeden silindi");
        return "/templates6";
    }
}
