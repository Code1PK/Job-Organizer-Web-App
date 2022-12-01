package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobStatus extends AbstractEntity{

    private String name;

    @ManyToMany(mappedBy = "jobStatus")
    private final List<Job> jobs = new ArrayList<>();

    public JobStatus(String name){
        this.name = name;
    }

    public JobStatus(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}

