package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.JobStatusRepository;
import com.LiftOff.Job_Organizer.models.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("jobs/jobStatuses")
public class JobStatusController {

    @Autowired
    JobStatusRepository jobStatusRepository;

    @GetMapping("")
    public String displayJobStatus(Model model){
        model.addAttribute("title", "Job Statuses");
        model.addAttribute("jobStatuses", jobStatusRepository.findAll());
        return "jobStatuses/list";
    }

    @GetMapping("add")
    public String displayCreateStatusForm(Model model){
        model.addAttribute("title", "Add Job Status");
        model.addAttribute(new JobStatus());
        return "jobStatuses/add";
    }

    @PostMapping("add")
    public String processCreateStatusForm(@ModelAttribute @Valid JobStatus jobStatus, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Job Status");
            model.addAttribute(jobStatus);
            return "jobStatuses/add";
        }

        jobStatusRepository.save(jobStatus);
        return "redirect:";
    }

    @GetMapping("view/{jobStatusId}")
    public String displayViewJobStatus(Model model, @PathVariable int jobStatusId) {
        Optional<JobStatus> optJobStatus = jobStatusRepository.findById(jobStatusId);
        if (optJobStatus.isPresent()) {
            JobStatus jobStatus = (JobStatus) optJobStatus.get();
            model.addAttribute("jobStatus", jobStatus);
            return "jobStatuses/view";
        } else {
            return "redirect:";
        }
    }


    @PostMapping("/{Id}")
    public String processDeleteJobStatusForm(@PathVariable int Id) {
        Optional<JobStatus> optJobStatus = jobStatusRepository.findById(Id);
        if (optJobStatus.isPresent()) {
            jobStatusRepository.delete(optJobStatus.get());
        }
        return "redirect:";
    }
}