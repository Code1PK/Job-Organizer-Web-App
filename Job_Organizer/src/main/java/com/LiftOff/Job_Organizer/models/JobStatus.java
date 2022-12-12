package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobStatus extends AbstractEntity{

    @NotBlank(message="Do not leave blank!")
    @Size(min = 3, max = 20)
    private String name;

    @OneToMany
    @JoinColumn(name="job_status_id")
    private final List<Job> jobs = new ArrayList<>();

    public JobStatus(String name){
        super();
        this.name = name;
    }

    public JobStatus(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}