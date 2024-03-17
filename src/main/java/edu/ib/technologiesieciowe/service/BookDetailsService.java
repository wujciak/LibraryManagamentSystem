package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.entity.BookDetails;
import edu.ib.technologiesieciowe.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDetailsService {
    private final BookDetailsRepository bookDetailsRepository;

    @Autowired
    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public Iterable<BookDetails> getAll() {
        return bookDetailsRepository.findAll();
    }

    public BookDetails getOne(int bookDetailsId) {
        return bookDetailsRepository.findById(bookDetailsId).orElseThrow(() -> new RuntimeException("Book details not found"));
    }

    public BookDetails create(BookDetails bookDetails) {
        return bookDetailsRepository.save(bookDetails);
    }

    public void delete(int bookDetailsId) {
        if (!bookDetailsRepository.existsById(bookDetailsId)) {
            throw new RuntimeException();
        }
        bookDetailsRepository.deleteById(bookDetailsId);
    }
}
