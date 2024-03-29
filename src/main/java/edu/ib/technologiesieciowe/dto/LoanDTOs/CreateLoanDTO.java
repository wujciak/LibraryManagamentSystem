package edu.ib.technologiesieciowe.dto.LoanDTOs;

import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.model.User;

import java.util.Date;

public class CreateLoanDTO {
    private Book book;
    private User user;
    private Date dateOfStart;

    public CreateLoanDTO(Book book, User user, Date dateOfStart) {
        this.book = book;
        this.user = user;
        this.dateOfStart = dateOfStart;
    }

    public CreateLoanDTO() {
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

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }
}
