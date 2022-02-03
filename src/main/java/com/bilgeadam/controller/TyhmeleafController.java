package com.bilgeadam.controller;

import com.bilgeadam.dto.ThymeleafDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TyhmeleafController {

    //  http://localhost:8090/thymeleaf/deneme/44
    @GetMapping( path = {"thymeleaf/deneme","thymeleaf/deneme/{id}"}  )
    public String getThymeleaf(Model model, @PathVariable(name="id",required = false) Long thymeleafId){
        ThymeleafDto thymeleafDto;
        if(thymeleafId==null){
            thymeleafDto=new ThymeleafDto(0,"",0.0);
        }else{
            thymeleafDto=new ThymeleafDto(thymeleafId,"Formül",66.0);
        }
        model.addAttribute("thymeleaf_key",thymeleafDto);
        return "templates6";
    }

    //http://localhost:8090/thymeleaf/deneme
    @PostMapping( path = {"thymeleaf/deneme","thymeleaf/deneme/{id}"}  )
    public String postThymeleaf(Model model, ThymeleafDto thymeleafDto, BindingResult bindingResult){
        System.out.println("post datası "+thymeleafDto);
        model.addAttribute("thymeleaf_key",thymeleafDto);
        return "templates6";
    }


}
