package edu.ib.technologiesieciowe.dto.ReviewDTOs;

import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CreateReviewDTO {
    @NotNull(message = "Review should include book.")
    @Schema(name = "book")
    private Book book;

    @NotNull(message = "Review should include user.")
    @Schema(name = "user")
    private User user;

    @NotNull(message = "Review should include score.")
    @Schema(name = "score", example = "7")
    private int score;

    @Schema(name = "comment", example = "Enjoyed this book so much!")
    private String comment;

    @NotNull(message = "Review should include date.")
    @Schema(name = "date of review", example = "2012-03-12")
    private Date dateOfReview;

    public CreateReviewDTO(Book book, User user, int score, String comment, Date dateOfReview) {
        this.book = book;
        this.user = user;
        this.score = score;
        this.comment = comment;
        this.dateOfReview = dateOfReview;
    }

    public CreateReviewDTO() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }
}
