package com.LiftOff.Job_Organizer.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Interview extends AbstractEntity {

    @NotBlank(message="Company name is Required")
    @Size(min=3, max=50, message="Company name must be between 3 and 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private InterviewDetails interviewDetails;

    @ManyToOne
    @NotNull(message = "Company is required!")
    private Company company;

    public Interview(String name, Company company){
        this.name = name;
        this.company = company;
    }

    public Interview(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Company getCompany(){
        return company;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    public InterviewDetails getInterviewDetails(){
        return interviewDetails;
    }

    public void setInterviewDetails(InterviewDetails interviewDetails){
        this.interviewDetails = interviewDetails;
    }

    @Override
    public String toString(){
        return name;
    }
}
