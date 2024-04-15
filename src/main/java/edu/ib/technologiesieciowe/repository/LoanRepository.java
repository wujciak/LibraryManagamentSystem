package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {
    @Query("SELECT l FROM Loan l JOIN l.user u JOIN u.auth a WHERE a.username = :username")
    Iterable<Loan> findByAuthUsername(@Param("username") String username);
}
