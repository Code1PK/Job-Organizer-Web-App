package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController (){
        columnChoices.put("all", "All");
        columnChoices.put("company", "Company");
        columnChoices.put("interview", "Interview");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("title", "List");
        model.addAttribute("job", jobRepository.findAll());
        model.addAttribute("company", companyRepository.findAll());
        model.addAttribute("interview", interviewRepository.findAll());

    return "jobs/list";
    }
}
