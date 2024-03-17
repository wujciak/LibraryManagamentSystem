package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.entity.Review;
import edu.ib.technologiesieciowe.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Iterable<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review getOne(int reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public void delete(int reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new RuntimeException();
        }
        reviewRepository.deleteById(reviewId);
    }
}
