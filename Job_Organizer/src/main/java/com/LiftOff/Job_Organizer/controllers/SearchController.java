package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.models.Job;
import com.LiftOff.Job_Organizer.models.JobData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String search() {
        return "search";
    }

    @PostMapping("results")
    public String showResults(Model model, @RequestParam String searchTerm){
        Iterable<Job> jobs;
        jobs = JobData.findByValue(searchTerm, jobRepository.findAll());
        model.addAttribute("title", "Jobs with Keyword" + ": " + searchTerm);
        model.addAttribute("jobs", jobs);
        return "search";
    }

}





//package com.LiftOff.Job_Organizer.controllers;
//
//import com.LiftOff.Job_Organizer.data.CompanyRepository;
//import com.LiftOff.Job_Organizer.data.InterviewRepository;
//import com.LiftOff.Job_Organizer.data.JobRepository;
//import com.LiftOff.Job_Organizer.data.JobStatusRepository;
//import com.LiftOff.Job_Organizer.models.Company;
//import com.LiftOff.Job_Organizer.models.Job;
//import com.LiftOff.Job_Organizer.models.JobStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.stereotype.Controller;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//
//import static java.lang.Integer.parseInt;
//
//@Controller
////@RequestMapping("search")
//public class SearchController {
//
//    @GetMapping
//    public String searchView() {
//        return "search";
//    }
//
////    @Autowired
////    private JobRepository jobRepository;
//
////    @RequestMapping("")
////    public String search(Model model) {
////        model.addAttribute("columns", columnChoices);
////        return "search";
////    }
//
////    @GetMapping("/search")
////    public String showSearchPage(Model model) {
////        model.addAttribute("title", "Search Jobs");
////        model.addAttribute("jobs", jobRepository.findAll());
////        return "search";
////    }
//
////    @RequestMapping("")
////    public String search(Model model) {
////        model.addAttribute("title", "Search Jobs");
////        return "search";
////    }
//
////    @PostMapping("results")
////    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
////        Iterable<Job> jobs;
////        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
////            jobs = jobRepository.findAll();
////        } else {
////            jobs = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
////        }
////        model.addAttribute("columns", columnChoices);
////        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
////        model.addAttribute("jobs", jobs);
////
////        return "search";
////    }
//
//}