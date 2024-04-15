package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.exception.EntityNotFoundException;
import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::create);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public void delete(int bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw EntityNotFoundException.create();
        }
        bookRepository.deleteById(bookId);
    }

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public Book update(int bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPublisher(updatedBook.getPublisher());
        existingBook.setYearOfPublish(updatedBook.getYearOfPublish());
        existingBook.setAvailableCopies(updatedBook.getAvailableCopies());

        return bookRepository.save(existingBook);
    }

}
