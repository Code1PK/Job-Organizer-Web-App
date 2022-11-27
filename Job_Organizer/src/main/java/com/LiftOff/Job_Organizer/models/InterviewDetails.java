package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InterviewDetails extends AbstractEntity {

    private String description;

    public InterviewDetails(){}


    public InterviewDetails(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
