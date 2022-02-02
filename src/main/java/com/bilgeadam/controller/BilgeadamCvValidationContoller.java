package com.bilgeadam.controller;
import com.bilgeadam.dto.BilgeadamCvValidationDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class BilgeadamCvValidationContoller {

    //root page
    //http://localhost:8080/formurl
    @GetMapping("/")
    public String getRoot(Model model){
        model.addAttribute("cv_key","Ana Sayfaya Hoşgeldiniz");
        return "index";
    }

    //Form
    //Get method
    //http://localhost:8080/formurl
    @GetMapping("/formurl")
    public String getCvFormValidation(Model model){
    model.addAttribute("cv_key",new BilgeadamCvValidationDto());
        return "formvalidation";
    }

    //Post Method
    //Validemiz Modaya uyuyor 1000Dolar
    //http://localhost:8080/formurl
    @PostMapping("/formurl")
    public String postCvFormValidation(@Valid @ModelAttribute("cv_key") BilgeadamCvValidationDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata var....");
            return "formvalidation";
        }
        log.info("Başarılı: "+dto);
        log.info("Database kaydedildi !!!");
        log.info("Dosyaya yazıldı !!!");
        return "success";
    }
}
