package edu.ib.technologiesieciowe.dto.BookDetailsDTOs;

import edu.ib.technologiesieciowe.model.Book;

public class CreateBookDetailsDTO {
    private Book book;
    private String genre;
    private String summary;

    public CreateBookDetailsDTO(Book book, String genre, String summary) {
        this.book = book;
        this.genre = genre;
        this.summary = summary;
    }

    public CreateBookDetailsDTO() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
