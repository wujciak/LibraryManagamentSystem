package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.BookDetailsDTOs.BookDetailsDTO;
import edu.ib.technologiesieciowe.dto.BookDetailsDTOs.CreateBookDetailsDTO;
import edu.ib.technologiesieciowe.model.BookDetails;
import edu.ib.technologiesieciowe.service.BookDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/bookDetails")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin
@Tag(name = "Book Details")
public class BookDetailsController {
    private final BookDetailsService bookDetailsService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookDetailsController(BookDetailsService bookDetailsService, ModelMapper modelMapper) {
        this.bookDetailsService = bookDetailsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public @ResponseBody Iterable<BookDetailsDTO> getAll() {
        Iterable<BookDetails> bookDetails = bookDetailsService.getAll();
        return mapBookDetailsToDTOs(bookDetails);
    }

    @GetMapping("/get/{bookDetailsId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public BookDetailsDTO getOne(@PathVariable int bookDetailsId) {
        BookDetails bookDetails = bookDetailsService.getOne(bookDetailsId);
        return modelMapper.map(bookDetails, BookDetailsDTO.class);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody BookDetailsDTO create(@RequestBody CreateBookDetailsDTO createBookDetailsDTO) {
        BookDetails bookDetails = modelMapper.map(createBookDetailsDTO, BookDetails.class);
        BookDetails createdBookDetails = bookDetailsService.create(bookDetails);
        return modelMapper.map(createdBookDetails, BookDetailsDTO.class);
    }

    @DeleteMapping("/delete/{bookDetailsId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int bookDetailsId) {
        bookDetailsService.delete(bookDetailsId);
    }

    @PutMapping("/update/{bookDetailsId}")
    public @ResponseBody BookDetailsDTO update(@PathVariable int bookDetailsId, @Valid @RequestBody BookDetailsDTO bookDetailsDTO) {
        BookDetails bookDetails = modelMapper.map(bookDetailsDTO, BookDetails.class);
        BookDetails updatedBookDetails = bookDetailsService.update(bookDetailsId, bookDetails);
        return modelMapper.map(updatedBookDetails, BookDetailsDTO.class);
    }

    private Iterable<BookDetailsDTO> mapBookDetailsToDTOs(Iterable<BookDetails> bookDetails) {
        return StreamSupport.stream(bookDetails.spliterator(), false)
                .map(bookDetail -> modelMapper.map(bookDetail, BookDetailsDTO.class))
                .collect(Collectors.toList());
    }
}
