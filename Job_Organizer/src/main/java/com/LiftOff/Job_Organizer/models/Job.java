package com.LiftOff.Job_Organizer.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Job extends AbstractEntity{

    @NotNull(message="Title required!")
    @NotBlank(message="Do not leave blank!")
    @Size(min = 3, max = 100)
    private String title;

    @NotNull(message="Company name required!")
    @NotBlank(message="Do not leave blank!")
    @Size(min = 3, max = 100)
    private String company;

    @NotNull(message="Location required!")
    @NotBlank(message="Do not leave blank!")
    @Size(min = 3, max = 100)
    private String location;

    @NotNull(message="Job URL required!")
    @NotBlank(message="Do not leave blank!")
    private String jobUrl;

    @NotNull(message="Description required!")
    @NotBlank(message="Do not leave blank!")
    @Size(min = 3, max = 20000)
    private String description;

    @ManyToOne
    private JobStatus jobStatus;

    public Job() {}

    public Job(String title, String company, String location, String jobUrl, String description, JobStatus jobStatus) {
        super();
        this.title = title;
        this.company = company;
        this.location = location;
        this.jobUrl = jobUrl;
        this.description = description;
        this.jobStatus = jobStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

}