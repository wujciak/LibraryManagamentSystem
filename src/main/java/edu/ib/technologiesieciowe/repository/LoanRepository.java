package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {
}
