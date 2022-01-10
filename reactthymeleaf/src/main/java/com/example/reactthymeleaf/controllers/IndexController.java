package com.example.reactthymeleaf.controllers;

import com.example.reactthymeleaf.Loan.Loan;
import com.example.reactthymeleaf.Loan.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Configuration
public class IndexController {

    //@Value("${spring.datasource.username}")
    //private String userName;

    private LoanRepository loanRepository;

    public IndexController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

       // System.out.println(userName);
        List<Loan> loans = loanRepository.findAll();
        model.addAttribute("title", "Apenas um teste");
        model.addAttribute("total", loans.stream().count());
        System.out.println(loans);

        return "home";
    }
}
