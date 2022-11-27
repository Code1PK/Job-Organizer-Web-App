package com.LiftOff.Job_Organizer.data;

import com.LiftOff.Job_Organizer.models.Interview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends CrudRepository <Interview, Integer> {
}
