package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
