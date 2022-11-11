package com.LiftOff.Job_Organizer.data;
import com.LiftOff.Job_Organizer.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
