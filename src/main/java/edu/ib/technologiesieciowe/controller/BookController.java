package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@PreAuthorize("hasRole('ADMIN')")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public @ResponseBody Iterable<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public Book getOne(@PathVariable int bookId) {
        return bookService.getOne(bookId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int bookId) {
        bookService.delete(bookId);
    }
}