package com.LiftOff.Job_Organizer.data;

import com.LiftOff.Job_Organizer.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
