package org.spring.springmvc2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/thymeleafIndex")
    public String index(Model model){
        model.addAttribute("title","thymeleaf Project");
        return "thymeleaf/thymeleafIndex";
    }
}
