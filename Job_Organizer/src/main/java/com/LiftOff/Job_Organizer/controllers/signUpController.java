package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CustomerRepository;
import com.LiftOff.Job_Organizer.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class signUpController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("signUp")
    public String signUp() {
        return "signUp";
    }

    @PostMapping("signUp")
    public String processSignUpForm(@ModelAttribute @Valid Customer newCustomer, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "SignUp");
            return "signUp";
        }
        customerRepository.save(newCustomer);
        return"redirect:";
    }

}
