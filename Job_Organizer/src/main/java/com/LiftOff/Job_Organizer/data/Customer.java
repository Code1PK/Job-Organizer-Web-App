package com.LiftOff.Job_Organizer.data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer extends CrudRepository<com.LiftOff.Job_Organizer.models.Customer, Integer> {
}
