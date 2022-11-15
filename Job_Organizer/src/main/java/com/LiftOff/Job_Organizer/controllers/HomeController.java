package com.LiftOff.Job_Organizer.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("jobs")
    public String displayListOfJobs() {
        return "../list";
    }
}
