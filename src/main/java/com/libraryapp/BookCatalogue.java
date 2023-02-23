package com.libraryapp;

import jakarta.persistence.*;

@Entity
public class BookCatalogue {
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer bookID;
    private String author;
    private String title;
    private Boolean availability;

    public BookCatalogue(Integer bookID,
                         String author,
                         String title,
                         Boolean availability) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.availability = availability;
    }
    public BookCatalogue() {
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

}
