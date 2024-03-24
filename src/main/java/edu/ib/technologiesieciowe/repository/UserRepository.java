package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
