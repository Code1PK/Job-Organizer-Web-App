package com.LiftOff.Job_Organizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsController {
    @GetMapping("jobs/add")
    public String displayAddJobForm() {
        return "jobs/add";
    }
}
