package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.BookDTOs.CreateBookDTO;
import edu.ib.technologiesieciowe.dto.BookDTOs.BookDTO;
import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/book")
@CrossOrigin
@Tag(name = "Book")
public class BookController {
    private final ModelMapper modelMapper;
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public @ResponseBody Iterable<BookDTO> getAll() {
        Iterable<Book> books = bookService.getAll();
        return mapBooksToDTOs(books);
    }

    @GetMapping("/get/{bookId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public BookDTO getOne(@PathVariable int bookId) {
        Book book = bookService.getOne(bookId);
        return modelMapper.map(book, BookDTO.class);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDTO create(@Valid @RequestBody CreateBookDTO createBookDTO) {
        Book book = modelMapper.map(createBookDTO, Book.class);
        Book createdBook = bookService.create(book);
        return modelMapper.map(createdBook, BookDTO.class);
    }

    @DeleteMapping("/delete/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int bookId) {
        bookService.delete(bookId);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public @ResponseBody Iterable<BookDTO> searchByTitle(@RequestParam String title) {
        List<Book> books = bookService.searchByTitle(title);
        return mapBooksToDTOs(books);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{bookId}")
    public @ResponseBody BookDTO update(@PathVariable int bookId, @Valid @RequestBody BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        Book updatedBook = bookService.update(bookId, book);
        return modelMapper.map(updatedBook, BookDTO.class);
    }

    private Iterable<BookDTO> mapBooksToDTOs(Iterable<Book> books) {
        return StreamSupport.stream(books.spliterator(), false)
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }
}