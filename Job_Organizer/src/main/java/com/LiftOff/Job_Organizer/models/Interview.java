package com.LiftOff.Job_Organizer.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Interview extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private InterviewDetails interviewDetails;

    @ManyToOne
    @NotNull(message = "Company is required!")
    private Company company;

    @NotNull(message="Enter interviewer email")
    @NotBlank(message="Must not be blank!")
    private String interviewEmail;

    @NotNull(message="Enter interviewer phone number")
    @NotBlank(message="Must not be blank!")
    private String interviewNumber;

    private String interviewType;

    private String meetingLink;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate interviewDate;

    @ManyToOne
    private Job job;


    public Interview(Company company, String interviewEmail, String interviewNumber,String interviewType, String meetingLink, LocalDate interviewDate){
        this.company = company;
        this.interviewEmail = interviewEmail;
        this.interviewNumber = interviewNumber;
        this.interviewType = interviewType;
        this.meetingLink = meetingLink;
        this.interviewDate = interviewDate;
    }

    public Interview(){}

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

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interviewType='" + interviewType + '\'' +
                ", interviewDate=" + interviewDate +
                ", job=" + job +
                '}';
    }
}
