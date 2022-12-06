package com.LiftOff.Job_Organizer.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Interview extends AbstractEntity {

    @NotBlank(message="Job name is Required")
    @Size(min=3, max=50, message="Job name must be between 3 and 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private InterviewDetails interviewDetails;

    @ManyToOne
    @NotNull(message = "Company is required!")
    private Company company;

    @NotNull(message="Location is required!")
    @NotBlank(message="Location is required!")
    @Size(min=3, max=100)
    private String location;

    @NotNull(message="Enter job URL")
    @NotBlank(message="Must not be blank!")
    private String jobURL;


    public Interview(String name, Company company, String location, String jobURL){
        this.name = name;
        this.company = company;
        this.location = location;
        this.jobURL = jobURL;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobURL() {
        return jobURL;
    }

    public void setJobURL(String jobURL) {
        this.jobURL = jobURL;
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
