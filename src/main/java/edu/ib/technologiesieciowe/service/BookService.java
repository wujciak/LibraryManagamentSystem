package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.entity.Book;
import edu.ib.technologiesieciowe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getOne(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void delete(int bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException();
        }
        bookRepository.deleteById(bookId);
    }
}
