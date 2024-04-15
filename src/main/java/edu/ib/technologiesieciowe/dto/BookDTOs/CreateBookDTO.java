package edu.ib.technologiesieciowe.dto.BookDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateBookDTO {
    @NotBlank(message = "ISBN is mandatory.")
    @Schema(name = "isbn", example = "0-061-96436-0")
    private String isbn;

    @NotBlank(message = "Title is mandatory.")
    @Schema(name = "title", example = "Romek i Atomek")
    private String title;

    @NotBlank(message = "Author is mandatory.")
    @Schema(name = "author", example = "Kendrick Lamar")
    private String author;

    @NotBlank(message = "Publisher is mandatory.")
    @Schema(name = "publisher", example = "O.E. Pazdro")
    private String publisher;

    @NotNull(message = "Year of publish is mandatory.")
    @Schema(name = "year of publication", example = "2002")
    private int yearOfPublish;

    @NotNull(message = "Number of available copies is mandatory.")
    @Schema(name = "available copies", example = "12")
    private int availableCopies;

    public CreateBookDTO(String isbn, String title, String author, String publisher, int yearOfPublish, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.availableCopies = availableCopies;
    }

    public CreateBookDTO() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
