package com.bilgeadam.controller;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
@Log4j2
public class BilgeadamCvValidationDto {

    //root page
    @GetMapping("/")
    public String getRoot(Model model){
        model.addAttribute("cv_key","Ana Sayfaya Hoşgeldiniz");
        return "index";
    }

    //Form
    //Get method
    @GetMapping("/form")
    public String getCvFormValidation(Model model){
    model.addAttribute("cv_key",new BilgeadamCvValidationDto());
        return "formvalidation";
    }

    @GetMapping("/form")
    //Validemiz Modaya uyuyor 1000Dolar
    public String postCvFormValidation(@Valid @ModelAttribute("cv_key") BilgeadamCvValidationDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata var....");
            return "formvalidation";
        }
        log.info("Başarılı");
        return "success";
    }


}
