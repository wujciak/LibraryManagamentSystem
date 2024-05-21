package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.ReviewDTOs.CreateReviewDTO;
import edu.ib.technologiesieciowe.dto.ReviewDTOs.ReviewDTO;
import edu.ib.technologiesieciowe.model.Review;
import edu.ib.technologiesieciowe.service.ReviewService;
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
@RequestMapping("/api/review")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
@CrossOrigin
@Tag(name = "Review")
public class ReviewController {
    private final ReviewService reviewService;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewController(ReviewService reviewService, ModelMapper modelMapper) {
        this.reviewService = reviewService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<ReviewDTO> getAll() {
        Iterable<Review> reviews = reviewService.getAll();
        return mapReviewsToDTOs(reviews);
    }

    @GetMapping("/get/{reviewId}")
    public ReviewDTO getOne(@PathVariable int reviewId) {
        Review review = reviewService.getOne(reviewId);
        return modelMapper.map(review, ReviewDTO.class);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody ReviewDTO create(@Valid @RequestBody CreateReviewDTO createReviewDTO) {
        Review review = modelMapper.map(createReviewDTO, Review.class);
        Review createdReview = reviewService.create(review);
        return modelMapper.map(createdReview, ReviewDTO.class);
    }

    @DeleteMapping("/delete/{reviewId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable int reviewId) {
        reviewService.delete(reviewId);
    }

    private Iterable<ReviewDTO> mapReviewsToDTOs(Iterable<Review> reviews) {
        return StreamSupport.stream(reviews.spliterator(), false)
                .map(review -> modelMapper.map(review, ReviewDTO.class))
                .collect(Collectors.toList());
    }
}
