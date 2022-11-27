package com.LiftOff.Job_Organizer.models.dto;

import com.LiftOff.Job_Organizer.models.Interview;
import com.LiftOff.Job_Organizer.models.InterviewStatus;

import javax.validation.constraints.NotNull;

public class InterviewStatusDTO {

    @NotNull
    private Interview interview;

    @NotNull
    private InterviewStatus interviewStatus;

    public InterviewStatusDTO(){}

    public Interview getInterviews() {
        return interview;
    }

    public void setInterviews(Interview interview) {
        this.interview = interview;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}
