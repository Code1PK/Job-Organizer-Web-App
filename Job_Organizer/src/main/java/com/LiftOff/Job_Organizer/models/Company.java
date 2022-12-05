package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company extends AbstractEntity {

    @Size(min=3, max=50, message="Company Name must be between 3 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "company")
    private final List<Interview> interviews = new ArrayList<>();

    public Company(@Size(min=3, message="Name must be at least 3 characters") String name){
        this.name=name;
    }

    public Company(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Interview> getInterviews(){
        return interviews;
    }

    @Override
    public String toString(){
        return name;
    }
}
