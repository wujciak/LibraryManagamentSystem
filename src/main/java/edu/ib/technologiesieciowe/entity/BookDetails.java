package edu.ib.technologiesieciowe.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_details", schema = "librarydb")
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_details_id")
    private int bookDetailsId;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Basic
    @Column(name = "genre")
    private String genre;

    @Basic
    @Column(name = "summary")
    private String summary;

    @Basic
    @Column(name = "cover_image_url", unique = true)
    private String coverImageURL;

    public int getBookDetailsId() {
        return bookDetailsId;
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
