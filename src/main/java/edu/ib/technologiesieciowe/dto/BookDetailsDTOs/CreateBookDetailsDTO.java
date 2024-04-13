package edu.ib.technologiesieciowe.dto.BookDetailsDTOs;

import edu.ib.technologiesieciowe.model.Book;

public class CreateBookDetailsDTO {
    private Book book;
    private String genre;
    private String summary;
    private String coverImageURL;


    public CreateBookDetailsDTO(Book book, String genre, String summary, String coverImageURL) {
        this.book = book;
        this.genre = genre;
        this.summary = summary;
        this.coverImageURL = coverImageURL;
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

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }
}
