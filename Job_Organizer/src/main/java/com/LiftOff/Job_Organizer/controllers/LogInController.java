package com.LiftOff.Job_Organizer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LogInController {

    // Login form
   @GetMapping ("login")
   public String login() {
       return "loggingIn/welcomePage";
   }
   @PostMapping("login")
   public String loggingIntoWelcomePage(@RequestParam String username,
                                        @RequestParam String password){
       return "loggingIn/welcomePage";

   }

   //login form with error

    @GetMapping("error")
    public String loginError(Model model) {
       model.addAttribute("Error",true);
       return "loggingIn/error";
    }




}
