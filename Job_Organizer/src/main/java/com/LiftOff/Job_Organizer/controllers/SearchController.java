package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.models.Job;
import com.LiftOff.Job_Organizer.models.JobData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.LiftOff.Job_Organizer.controllers.ListController.columnChoices;

@Controller
@RequestMapping ("search")
public class SearchController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private InterviewRepository interviewRepository;


    @RequestMapping("")
    public String search (Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults (Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        Iterable<Job> jobs;
        if(searchTerm.toLowerCase().equals("all")  || searchTerm.equals("")) {
            jobs = jobRepository.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("jobs", jobs);

        return "search";
    }
}
