package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.data.JobStatusRepository;
import com.LiftOff.Job_Organizer.models.Job;
import com.LiftOff.Job_Organizer.models.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("jobs")
public class JobsController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobStatusRepository jobStatusRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute(new Job());
        model.addAttribute("title", "Add Job Application");
        model.addAttribute("jobStatus", jobStatusRepository.findAll());
        model.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("interviews", interviewRepository.findAll());
        return "jobs/add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, @RequestParam int jobStatusId,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "jobs/add";
        }
        Optional<JobStatus> optJobStatus = jobStatusRepository.findById(jobStatusId);
        newJob.setJobStatus(optJobStatus.get());
        jobRepository.save(newJob);
        return "redirect:";
    }


    @GetMapping("details/{Id}")
    public String displayJobDetails(@PathVariable Integer Id, Model model) {

        Optional<Job> result = jobRepository.findById(Id);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Job ID: " + Id);
        } else {
            Job job = result.get();
            model.addAttribute("title", job.getTitle() + " Details");
            model.addAttribute("job", job);
            model.addAttribute("jobStatus", job.getJobStatus());
            model.addAttribute("companies", job.getCompany());
            model.addAttribute("interviews", job.getInterview());
        }

        return "jobs/details";
    }

    @GetMapping("delete")
    public String displayDeleteJobForm(Model model) {
        model.addAttribute("title", "Delete Job");
        model.addAttribute("jobs", jobRepository.findAll());
        return "jobs/delete";
    }

    @PostMapping("delete")
    public String processDeleteJobForm(@RequestParam(required = false) int[] jobIds) {
        if (jobIds != null) {
            for (int id : jobIds) {
                jobRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @RequestMapping(path = "/edit/{Id}", method = RequestMethod.GET)
    public String displayEditJobForm(@PathVariable int Id, Model model) {

        Optional<Job> result = jobRepository.findById(Id);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Job ID: " + Id);
        } else {
            Job job = result.get();
            model.addAttribute("title", "Edit Job Application");
            model.addAttribute("jobs", job);
            model.addAttribute("jobStatus", jobStatusRepository.findAll());
            model.addAttribute("companies", companyRepository.findAll());
            model.addAttribute("selected", job.getJobStatus().getId());
        }
        return "jobs/edit";
    }

    @RequestMapping(path = "/edit/{Id}", method = RequestMethod.POST)
    public String processEditJobForm(@ModelAttribute @Valid Job job, @RequestParam int jobStatusId,
                                     Errors errors, Model model, @RequestParam String jobId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Job Application");
            return "jobs/edit";
        }
        Optional<Job> jobInDb = jobRepository.findById(parseInt(jobId));
        if (jobInDb.isPresent()) {
            Job jobJob = jobInDb.get();
            jobJob.setTitle(job.getTitle());
            jobJob.setCompany(job.getCompany());
            jobJob.setLocation(job.getLocation());
            jobJob.setJobUrl(job.getJobUrl());
            jobJob.setDescription(job.getDescription());
            Optional<JobStatus> optJobStatus = jobStatusRepository.findById(jobStatusId);
            jobJob.setJobStatus(optJobStatus.get());
            jobRepository.save(jobJob);
        }
        return "redirect:/jobs/details/" + jobId;
    }

}
