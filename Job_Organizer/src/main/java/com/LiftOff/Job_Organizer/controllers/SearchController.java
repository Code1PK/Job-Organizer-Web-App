package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.models.Company;
import com.LiftOff.Job_Organizer.models.Interview;
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
        Iterable<Job> jobs = null;
        Iterable<Company> companies = null;
        Iterable<Interview> interviews = null;
        if(searchType == "all" || searchType == "") {
            if(searchTerm.toLowerCase().equals("all")  || searchTerm.equals("")) {
                jobs = jobRepository.findAll();
            } else {
                jobs = JobData.findByJobValue(searchTerm, jobRepository.findAll());
            }
        }
        if(searchType == "company" || searchType == "") {
            if(searchTerm.toLowerCase().equals("all")  || searchTerm.equals("")) {
                companies = companyRepository.findAll();
            } else {
                companies = JobData.findByCompanyValue(searchTerm, companyRepository.findAll());
            }
        }
        if(searchType == "interview" || searchType == "") {
            if(searchTerm.toLowerCase().equals("all")  || searchTerm.equals("")) {
                interviews = interviewRepository.findAll();
            } else {
                interviews = JobData.findByInterviewValue(searchTerm, interviewRepository.findAll());
            }
        }
        
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("jobs", jobs);
        model.addAttribute("companies", companies);
        model.addAttribute("interviews", interviews);
        

        return "search";
    }
}
