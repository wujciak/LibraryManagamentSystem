package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.Auth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, Integer> {
    Optional<Auth> findByUsername(String username);
}
