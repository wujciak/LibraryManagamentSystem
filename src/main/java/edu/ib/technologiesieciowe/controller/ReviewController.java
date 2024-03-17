package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.entity.Review;
import edu.ib.technologiesieciowe.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{reviewId}")
    public Review getOne(@PathVariable int reviewId) {
        return reviewService.getOne(reviewId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Review create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @DeleteMapping("/{reviewId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int reviewId) {
        reviewService.delete(reviewId);
    }
}
