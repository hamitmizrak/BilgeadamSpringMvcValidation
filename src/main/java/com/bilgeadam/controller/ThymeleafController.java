package com.bilgeadam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    // localhost:8090/templates/thymeleaf1
    @GetMapping("templates/thymeleaf1")
    public String getThymleaf1() {
        return "templates1";
    }


    // localhost:8090/templates/thymeleaf2
    @GetMapping("templates/thymeleaf2")
    public String getThymleaf2(Model model) {
        model.addAttribute("key2", "Modelden geldim");
        return "templates2";
    }


    //other
    // localhost:8090/templates/thymeleaf3
    @GetMapping("templates/thymeleaf3")
    public String getThymleaf3() {
        return "other/templates3";
    }

    //css
    // localhost:8090/templates/thymeleaf4
    @GetMapping("templates/thymeleaf4")
    public String getThymleaf4() {
        return "templates4";
    }

    //js
    // localhost:8090/templates/thymeleaf5
    @GetMapping("templates/thymeleaf5")
    public String getThymleaf5() {
        return "templates5";
    }
}
