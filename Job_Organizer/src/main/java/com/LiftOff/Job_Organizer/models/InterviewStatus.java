package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InterviewStatus extends AbstractEntity {

    private String name;

    @ManyToMany (mappedBy = "interviewStatus")
    private final List<Interview> interviews = new ArrayList<>();

    public InterviewStatus(String name){
        this.name = name;
    }

    public InterviewStatus(){}

    public String name() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyName(String companyName) {
        this.name = companyName;
    }

    public List<Interview> getInterviews(){
        return interviews;
    }
}
