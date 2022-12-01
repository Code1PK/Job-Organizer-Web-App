package com.LiftOff.Job_Organizer.data;

import com.LiftOff.Job_Organizer.models.JobStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobStatusRepository extends CrudRepository<JobStatus, Integer> {
}
