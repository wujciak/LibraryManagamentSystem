package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.entity.Book;
import edu.ib.technologiesieciowe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
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
