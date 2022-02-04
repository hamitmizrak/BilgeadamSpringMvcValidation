package com.bilgeadam.controller;

import com.bilgeadam.dto.ThymeleafDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TyhmeleafController {

    //  http://localhost:8090/thymeleaf/44
    @GetMapping(path = {"/thymeleaf","/thymeleaf/{id}"}  )
    public String getThymeleaf(Model model, @PathVariable(name="id",required = false) Long id){
        ThymeleafDto thymeleafDto;
        if(id==null){
            thymeleafDto=new ThymeleafDto(0L,"",0.0);
        }else{
            thymeleafDto=new ThymeleafDto(id,"Formül",66.0);
        }
        model.addAttribute("message","Success !!!!");
        model.addAttribute("thymeleaf_key",thymeleafDto);
        return "/templates6";
    }

    //http://localhost:8090/thymeleaf
    @PostMapping(path = {"/thymeleaf","/thymeleaf/{id}"}  )
    public String postThymeleaf(Model model, ThymeleafDto thymeleafDto, BindingResult bindingResult){
        System.out.println("post datası "+thymeleafDto);

        if(bindingResult.hasErrors()){
            bindingResult.addError(new ObjectError("thymeleaf_key","Hata var"));
            return "/templates6";
        }

        model.addAttribute("message","Success !!!!");
        model.addAttribute("thymeleaf_key",thymeleafDto);
        return "templates6";
    }
}
