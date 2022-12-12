package com.LiftOff.Job_Organizer.data;



import com.LiftOff.Job_Organizer.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {

}