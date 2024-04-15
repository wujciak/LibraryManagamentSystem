package edu.ib.technologiesieciowe.dto.LoanDTOs;

import edu.ib.technologiesieciowe.model.Book;
import edu.ib.technologiesieciowe.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class CreateLoanDTO {
    @NotNull(message = "Loan should include book.")
    @Schema(name = "book")
    private Book book;

    @NotNull(message = "Loan should include user.")
    @Schema(name = "user")
    private User user;

    @NotNull(message = "Loan should include date of start.")
    @Schema(name = "date of start", example = "2015-03-03")
    private Date dateOfStart;

    @NotNull(message = "Loan should include date of end.")
    @Schema(name = "date of end", example = "2015-05-03")
    private Date dateOfEnd;

    @Schema(name = "date of return", example = "2015-04-21")
    private Date dateOfReturn;

    public CreateLoanDTO(Book book, User user, Date dateOfStart, Date dateOfEnd, Date dateOfReturn) {
        this.book = book;
        this.user = user;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.dateOfReturn = dateOfReturn;
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

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
