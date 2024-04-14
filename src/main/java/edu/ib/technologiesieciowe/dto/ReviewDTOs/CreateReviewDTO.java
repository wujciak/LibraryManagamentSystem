package edu.ib.technologiesieciowe.dto.ReviewDTOs;

import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.model.User;

import java.util.Date;

public class CreateReviewDTO {
    private Book book;
    private User user;
    private int score;
    private String comment;
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
