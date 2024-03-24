package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.model.BookDetails;
import edu.ib.technologiesieciowe.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookDetails")
public class BookDetailsController {
    private final BookDetailsService bookDetailsService;

    @Autowired
    public BookDetailsController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDetails> getAll() {
        return bookDetailsService.getAll();
    }

    @GetMapping("/{bookDetailsId}")
    public BookDetails getOne(@PathVariable int bookDetailsId) {
        return bookDetailsService.getOne(bookDetailsId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDetails create(@RequestBody BookDetails bookDetails) {
        return bookDetailsService.create(bookDetails);
    }

    @DeleteMapping("/{bookDetailsId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int bookDetailsId) {
        bookDetailsService.delete(bookDetailsId);
    }
}
