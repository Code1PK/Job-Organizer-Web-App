package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.data.JobRepository;
import com.LiftOff.Job_Organizer.models.Company;
import com.LiftOff.Job_Organizer.models.Interview;
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
@RequestMapping("interviews")
public class InterviewController {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public String displayInterviews(@RequestParam(required = false) Integer companyId, Model model){
       if (companyId == null){
           model.addAttribute("title", "All Interview");
           model.addAttribute("interviews", interviewRepository.findAll());
           model.addAttribute("jobs", jobRepository.findAll());
       } else{
           Optional<Company> result = companyRepository.findById(companyId);
           if (result.isEmpty()){
               model.addAttribute("title", "Invalid Company ID: " + companyId);
           } else {
               Company company = result.get();
               model.addAttribute("title", "Interviews by company" + company.getName());
               model.addAttribute("interviews",  company.getInterviews());
               model.addAttribute("jobs", company.getJobs());
           }
       }
       return "interviews/list";
    }

    @GetMapping("add")
    public String displayAddInterviewForm(Model model){
        model.addAttribute("title", "Add Interview");
        model.addAttribute(new Interview());
        model.addAttribute("companies", companyRepository.findAll());
//        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("job", jobRepository.findAll());
        return "interviews/add";
    }

    @PostMapping("add")
    public String processAddInterviewForm(@ModelAttribute @Valid Interview newInterview, @RequestParam int jobId, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Interview");
            return "interviews/add";
        }
        Optional<Job> optJob = jobRepository.findById(jobId);
        newInterview.setJob(optJob.get());
        interviewRepository.save(newInterview);
        return "redirect:";
    }


    @GetMapping("delete")
    public String displayDeleteInterviewForm(Model model){
        model.addAttribute("title", "Delete Interview");
        model.addAttribute("interviews", interviewRepository.findAll());
        return "interviews/delete";
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
    public String displayInterviewDetails(@RequestParam Integer interviewId, Model model){

        Optional<Interview> result = interviewRepository.findById(interviewId);

        if (result.isEmpty()){
            model.addAttribute("title", "Invalid Interview ID" + interviewId);
        } else{
            Interview interview = result.get();
            model.addAttribute("title", interview.getTitle() + "Details");
            model.addAttribute("interview", interview);
        }

        return "interviews/details";
    }

}
