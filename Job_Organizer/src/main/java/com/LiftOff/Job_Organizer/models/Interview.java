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

    @NotNull(message="Enter interviewer email")
    @NotBlank(message="Must not be blank!")
    private String interviewEmail;

    @NotNull(message="Enter interviewer phone number")
    @NotBlank(message="Must not be blank!")
    private String interviewNumber;

    private String interviewType;

    private String meetingLink;


    public Interview(String name, Company company, String location, String jobURL, String interviewEmail, String interviewNumber,String interviewType, String meetingLink){
        this.name = name;
        this.company = company;
        this.location = location;
        this.jobURL = jobURL;
        this.interviewEmail = interviewEmail;
        this.interviewNumber = interviewNumber;
        this.interviewType = interviewType;
        this.meetingLink = meetingLink;
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

    public String getInterviewEmail() {
        return interviewEmail;
    }

    public void setInterviewEmail(String interviewEmail) {
        this.interviewEmail = interviewEmail;
    }

    public String getInterviewNumber() {
        return interviewNumber;
    }

    public void setInterviewNumber(String interviewNumber) {
        this.interviewNumber = interviewNumber;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    @Override
    public String toString(){
        return name;
    }
}
