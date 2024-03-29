package edu.ib.technologiesieciowe.dto.BookDetailsDTOs;

import edu.ib.technologiesieciowe.model.Book;

public class BookDetailsDTO {
    private int bookDetailsId;
    private Book book;
    private String genre;
    private String summary;

    public BookDetailsDTO(int bookDetailsId, Book book, String genre, String summary) {
        this.bookDetailsId = bookDetailsId;
        this.book = book;
        this.genre = genre;
        this.summary = summary;
    }

    public BookDetailsDTO() {
    }

    public int getBookDetailsId() {
        return bookDetailsId;
    }

    public void setBookDetailsId(int bookDetailsId) {
        this.bookDetailsId = bookDetailsId;
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
