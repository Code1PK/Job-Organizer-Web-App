package com.LiftOff.Job_Organizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class forgetPasswordController {

    @GetMapping("forgetPassword")
    public String forgetPassword (){
        return "forgetPassword";
    }
}
