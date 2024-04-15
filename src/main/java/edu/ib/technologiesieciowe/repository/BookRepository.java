package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitleContaining(String title);
}
