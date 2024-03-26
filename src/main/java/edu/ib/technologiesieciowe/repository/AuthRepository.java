package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.Auth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Integer> {
    Optional<Auth> findByUsername(String username);
}
