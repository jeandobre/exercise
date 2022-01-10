package com.example.vuethymeleaf.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@Controller
public class HelloVueController {

  @Value("${spring.datasource.username}")
  private String userName;

  @GetMapping("/")
  ModelAndView showHelloPage() {
    Map<String, Object> model = new HashMap<>();
    model.put("title", "E ai pessoal!");
    System.out.print(userName);
    System.out.println("Apenas um teste");
    return new ModelAndView("index", model);
  }
}
