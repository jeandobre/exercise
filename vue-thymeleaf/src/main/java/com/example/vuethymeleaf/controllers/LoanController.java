package com.example.vuethymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanController {

    @GetMapping("/loan")
    public String listagem() {
        return "loan/index";
    }
}
