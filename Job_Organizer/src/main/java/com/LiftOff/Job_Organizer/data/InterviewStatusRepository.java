package com.LiftOff.Job_Organizer.data;

import com.LiftOff.Job_Organizer.models.InterviewStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewStatusRepository extends CrudRepository<InterviewStatus, Integer> {
}
