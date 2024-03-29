package edu.ib.technologiesieciowe.dto.BookDTOs;

public class BookDTO {
    private int bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearOfPublish;
    private int availableCopies;

    public BookDTO(int bookId, String isbn, String title, String author, String publisher, int yearOfPublish, int availableCopies) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.availableCopies = availableCopies;
    }

    public BookDTO() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
