package edu.ib.technologiesieciowe.dto.BookDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateBookDTO {
    @NotBlank(message = "ISBN is mandatory.")
    private String isbn;

    @NotBlank(message = "Title is mandatory.")
    private String title;

    @NotBlank(message = "Author is mandatory.")
    private String author;

    @NotBlank(message = "Publisher is mandatory.")
    private String publisher;

    @NotNull(message = "Year of publish is mandatory.")
    private int yearOfPublish;

    @NotNull(message = "Number of available copies is mandatory.")
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
