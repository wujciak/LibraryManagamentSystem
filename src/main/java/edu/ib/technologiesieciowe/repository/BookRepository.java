package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
