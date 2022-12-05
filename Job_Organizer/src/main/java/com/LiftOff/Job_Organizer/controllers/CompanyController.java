package com.LiftOff.Job_Organizer.controllers;

import com.LiftOff.Job_Organizer.data.CompanyRepository;
import com.LiftOff.Job_Organizer.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies/")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public String displayAllCompanies(Model model){
        model.addAttribute("title", "All companies");
        model.addAttribute("companies", companyRepository.findAll());
        return "companies/list";
    }

    @GetMapping("add")
    public String enterAddCompanyForm(Model model){
        model.addAttribute("title", "Add a Company");
        model.addAttribute(new Company());
        return "companies/add";
    }

    @PostMapping("add")
    public String processEnterCompanyForm(@ModelAttribute @Valid Company company, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Company");
            model.addAttribute(new Company());
            return "companies/add";
        }
        companyRepository.save(company);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteCompanyForm(Model model){
        model.addAttribute("title", "Delete Company");
        model.addAttribute("companies", companyRepository.findAll());
        return "/companies/delete";
    }

    @PostMapping("delete")
    public String processDeleteCompanyForm(@RequestParam(required = false) int[] companyIds){
        if (companyIds != null){
            for (int id : companyIds){
                companyRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}
