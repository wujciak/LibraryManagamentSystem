package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.entity.Book;
import edu.ib.technologiesieciowe.entity.BookDetails;
import edu.ib.technologiesieciowe.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookDetails")
public class BookDetailsController {

    private final BookDetailsRepository bookDetailsRepository;

    @Autowired
    public BookDetailsController(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDetails addBookDetails(@RequestBody BookDetails bookDetails) {
        return bookDetailsRepository.save(bookDetails);
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<BookDetails> getAllBookDetails() {
        return bookDetailsRepository.findAll();
    }

}
