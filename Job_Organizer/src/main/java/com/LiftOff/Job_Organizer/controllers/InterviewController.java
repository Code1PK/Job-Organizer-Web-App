package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CustomerRepository;
import com.LiftOff.Job_Organizer.data.InterviewRepository;
import com.LiftOff.Job_Organizer.data.InterviewStatusRepository;
import com.LiftOff.Job_Organizer.models.Interview;
import com.LiftOff.Job_Organizer.models.InterviewStatus;
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
    private InterviewStatusRepository interviewStatusRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String displayInterviews(@RequestParam(required = false) Integer interviewId, Model model){
       if (interviewId == null){
           model.addAttribute("title", "All Interview");
           model.addAttribute("interviews", interviewRepository.findAll());
       } else {
           Optional<InterviewStatus> result = interviewStatusRepository.findById(interviewId);
           if (result.isEmpty()){
               model.addAttribute("title", "Invalid Interview ID: " + interviewId);
           } else {
               InterviewStatus status = result.get();
               model.addAttribute("title", "Interview by Status:" + status.getName());
               model.addAttribute("interviews", status.getInterviews());
           }
       }
       return "/interviews/list";
    }

    @GetMapping("add")
    public String displayAddInterviewForm(Model model){
        model.addAttribute("title", "Add Interview");
        model.addAttribute(new Interview());
        model.addAttribute("status", interviewStatusRepository.findAll());
        return "/interviews/add";
    }

    @PostMapping("add")
    public String processAddInterviewForm(@ModelAttribute @Valid Interview interview, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add Interview");
            model.addAttribute(new Interview());
            return "/interviews/add";
        }

        interviewRepository.save(interview);
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
    public String displayInterviewDetails(@RequestParam Integer interviewId, Model model){

        Optional<Interview> result = interviewRepository.findById(interviewId);

        if (result.isEmpty()){
            model.addAttribute("title", "Invalid Interview ID" + interviewId);
        } else{
            Interview interview = result.get();
            model.addAttribute("title", interview.getCompanyName() + "Details");
            model.addAttribute("interview", interview);
            model.addAttribute("status", interview.getInterviewStatus());
        }

        return "/interviews/details";
    }

}
