package edu.ib.technologiesieciowe.repository;

import edu.ib.technologiesieciowe.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
