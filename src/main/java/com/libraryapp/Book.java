package com.libraryapp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book{
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_id_sequence"
    )
    private Integer bookId;
    private String author;
    private String title;
    private Boolean availability;
}
