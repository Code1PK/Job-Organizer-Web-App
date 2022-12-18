package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.data.JobStatusRepository;
import com.LiftOff.Job_Organizer.models.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobStatusRepository jobStatusRepository;

    @GetMapping("jobs")
    public String displayListOfJobs(Model model) {
        model.addAttribute("title", "All Jobs");
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("jobStatuses", jobStatusRepository.findAll());
        return "jobs/list";
    }


}