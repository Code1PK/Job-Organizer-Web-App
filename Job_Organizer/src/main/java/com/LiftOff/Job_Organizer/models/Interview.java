package com.LiftOff.Job_Organizer.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Interview extends AbstractEntity {

    @NotBlank(message="Company name is Required")
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private InterviewDetails interviewDetails;

    @ManyToMany
    private final List<InterviewStatus> interviewStatus = new ArrayList<>();

    public Interview(String companyName){
        this.companyName = companyName;
    }

    public Interview(){}

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public InterviewDetails getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(InterviewDetails interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public List<InterviewStatus> getInterviewStatus() {
        return interviewStatus;
    }

    public void addInterviewStatus(InterviewStatus addInterviewStatus){
        this.interviewStatus.add(addInterviewStatus);
    }

    @Override
    public String toString() {
        return companyName;
    }


}
