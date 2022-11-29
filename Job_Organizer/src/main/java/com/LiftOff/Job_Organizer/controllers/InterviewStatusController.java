package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.InterviewStatusRepository;
import com.LiftOff.Job_Organizer.models.InterviewStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/statuses")
public class InterviewStatusController {

    @Autowired
    InterviewStatusRepository interviewStatusRepository;

    @GetMapping
    public String displayInterviewStatus(Model model){
        model.addAttribute("title", "All Statuses");
        model.addAttribute("interviewStatus", interviewStatusRepository.findAll());
        return "/statuses/statuslist";
    }

    @GetMapping("addstatus")
    public String displayCreateStatusForm(Model model){
        model.addAttribute("title", "Add a Status");
        model.addAttribute(new InterviewStatus());
        return "/statuses/addstatus";
    }

    @PostMapping("addstatus")
    public String processCreateStatusForm(@ModelAttribute @Valid InterviewStatus interviewStatus, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Add a Status");
            model.addAttribute(interviewStatus);
            return "/statuses/addstatus";
        }

        interviewStatusRepository.save(interviewStatus);
        return "redirect:";
    }
}
