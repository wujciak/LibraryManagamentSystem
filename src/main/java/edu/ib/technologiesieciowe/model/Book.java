package edu.ib.technologiesieciowe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books", schema = "librarydb")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Basic
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Basic
    @Column(name = "author", nullable = false)
    private String author;

    @Basic
    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Basic
    @Column(name = "year_of_publish", nullable = false)
    private int yearOfPublish;

    @Basic
    @Column(name = "available_copies", nullable = false)
    private int availableCopies;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Loan> loans;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Review> reviews;

    @JsonIgnore
    @OneToOne(mappedBy = "book")
    private BookDetails bookDetails;

    public Book() {
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

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }
}
