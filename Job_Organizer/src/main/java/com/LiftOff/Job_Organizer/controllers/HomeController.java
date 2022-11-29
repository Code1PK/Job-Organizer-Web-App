package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;

    @GetMapping("jobs")
    public String displayListOfJobs(Model model) {
        model.addAttribute("title", "All Jobs");
        model.addAttribute("jobs", jobRepository.findAll());
        return "jobs/list";
    }
}
