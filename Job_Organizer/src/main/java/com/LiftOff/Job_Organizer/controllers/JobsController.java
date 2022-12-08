package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.data.JobStatusRepository;
import com.LiftOff.Job_Organizer.models.Job;
import com.LiftOff.Job_Organizer.models.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@Controller
public class JobsController {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobStatusRepository jobStatusRepository;

    @GetMapping("jobs/add")
    public String displayAddJobForm(Model model) {
        model.addAttribute(new Job());
        model.addAttribute("title", "Add Job Application");
        model.addAttribute("jobStatus", jobStatusRepository.findAll());
        return "jobs/add";
    }

    @PostMapping("jobs/add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, @RequestParam int jobStatusId,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "jobs/add";
        }
        Optional<JobStatus> optJobStatus = jobStatusRepository.findById(jobStatusId);
        newJob.setJobStatus(optJobStatus.get());
        jobRepository.save(newJob);
        return "redirect:/jobs";
        }


    @GetMapping("jobs/details/{Id}")
    public String displayJobDetails(@PathVariable Integer Id, Model model) {

        Optional<Job> result = jobRepository.findById(Id);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Job ID: " + Id);
        } else {
            Job job = result.get();
            model.addAttribute("title", job.getTitle() + " Details");
            model.addAttribute("job", job);
            model.addAttribute("status", job.getJobStatus());
        }

        return "jobs/details";
    }


}




