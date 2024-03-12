package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.entity.Review;
import edu.ib.technologiesieciowe.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {this.reviewRepository = reviewRepository;}

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Review addReview(@RequestBody Review review) {return reviewRepository.save(review);}

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Review> getAllReviews() {return reviewRepository.findAll();}
}
