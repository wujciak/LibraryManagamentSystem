package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.BookDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends CrudRepository<BookDetails, Integer> {
}
