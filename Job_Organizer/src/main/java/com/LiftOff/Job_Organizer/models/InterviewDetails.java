package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class InterviewDetails extends AbstractEntity {

    @Size(max = 5000, message = "Description is too long")
    private String description;

    public InterviewDetails(String description){
        this.description = description;
    }

    public InterviewDetails(){}

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
