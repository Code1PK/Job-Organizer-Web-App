package com.LiftOff.Job_Organizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }


    @PostMapping
    public String index(@RequestParam String username,
                                         @RequestParam String password){
        return "loggingIn/welcomePage";

    }
}