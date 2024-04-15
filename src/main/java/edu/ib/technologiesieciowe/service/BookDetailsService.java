package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.exception.EntityNotFoundException;
import edu.ib.technologiesieciowe.model.BookDetails;
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
        return bookDetailsRepository.findById(bookDetailsId).orElseThrow(EntityNotFoundException::create);
    }

    public BookDetails create(BookDetails bookDetails) {
        return bookDetailsRepository.save(bookDetails);
    }

    public void delete(int bookDetailsId) {
        if (!bookDetailsRepository.existsById(bookDetailsId)) {
            throw EntityNotFoundException.create();
        }
        bookDetailsRepository.deleteById(bookDetailsId);
    }

    public BookDetails update(int bookDetailsId, BookDetails updatedBookDetails) {
        BookDetails existingBookDetails = bookDetailsRepository.findById(bookDetailsId)
                .orElseThrow(() -> new EntityNotFoundException("Book details not found with id: " + bookDetailsId));

        existingBookDetails.setGenre(updatedBookDetails.getGenre());
        existingBookDetails.setSummary(updatedBookDetails.getSummary());
        existingBookDetails.setCoverImageURL(updatedBookDetails.getCoverImageURL());

        return bookDetailsRepository.save(existingBookDetails);
    }

}
