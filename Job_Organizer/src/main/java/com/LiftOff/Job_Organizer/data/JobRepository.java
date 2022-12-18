package com.LiftOff.Job_Organizer.data;

import com.LiftOff.Job_Organizer.models.Job;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {
}

