package edu.ib.technologiesieciowe.dto.BookDetailsDTOs;

import edu.ib.technologiesieciowe.model.Book;
import io.swagger.v3.oas.annotations.media.Schema;

public class CreateBookDetailsDTO {
    @Schema(name = "book")
    private Book book;

    @Schema(name = "genre", example = "Comedy")
    private String genre;

    @Schema(name = "summary", example = "Short comedy about ducks.")
    private String summary;

    @Schema(name = "cover image url", example = "s1aj34f5i36w3bifwf.webp")
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
