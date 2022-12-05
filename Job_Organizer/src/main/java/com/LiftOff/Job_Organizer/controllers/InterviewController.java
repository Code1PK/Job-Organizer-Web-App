package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.models.Company;
import com.LiftOff.Job_Organizer.models.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/interviews/")
public class InterviewController {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public String displayInterviews(@RequestParam(required = false) Integer company_Id, Model model){
       if (company_Id == null){
           model.addAttribute("title", "All Interview");
           model.addAttribute("interviews", interviewRepository.findAll());
       } else {
           Optional<Company> result = companyRepository.findById(company_Id);
           if (result.isEmpty()){
               model.addAttribute("title", "Invalid Company ID: " + company_Id);
           } else {
               Company company = result.get();
               model.addAttribute("title", "Interviews by company" + company.getName());
               model.addAttribute("interviews",  company.getInterviews());
           }
       }
       return "/interviews/list";
    }

    @GetMapping("add")
    public String displayAddInterviewForm(Model model){
        model.addAttribute("title", "Add Interview");
        model.addAttribute(new Interview());
        model.addAttribute("companies", companyRepository.findAll());
        return "/interviews/add";
    }

    @PostMapping("add")
    public String processAddInterviewForm(@ModelAttribute @Valid Interview newInterview, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Interview");
            return "/interviews/add";
        }
        interviewRepository.save(newInterview);
        return "redirect:";
    }


    @GetMapping("delete")
    public String displayDeleteInterviewForm(Model model){
        model.addAttribute("title", "Delete Interview");
        model.addAttribute("interviews", interviewRepository.findAll());
        return "/interviews/delete";
    }

    @PostMapping("delete")
    public String processDeleteInterviewForm(@RequestParam(required = false) int[] interviewIds){
        if (interviewIds != null){
            for (int id : interviewIds){
                interviewRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("details")
    public String displayInterviewDetails(@RequestParam Integer interview_Id, Model model){

        Optional<Interview> result = interviewRepository.findById(interview_Id);

        if (result.isEmpty()){
            model.addAttribute("title", "Invalid Interview ID" + interview_Id);
        } else{
            Interview interview = result.get();
            model.addAttribute("title", interview.getName() + "Details");
            model.addAttribute("interview", interview);
        }

        return "/interviews/details";
    }

}
