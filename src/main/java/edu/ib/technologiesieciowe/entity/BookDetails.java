package edu.ib.technologiesieciowe.entity;

import jakarta.persistence.*;

@Entity
public class BookDetails {

    // dodam tutaj klucz obcy bookId

    private String genre;

    private String summary;

    private String coverImageURL;

}
