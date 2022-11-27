package com.LiftOff.Job_Organizer.data;
import com.LiftOff.Job_Organizer.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
