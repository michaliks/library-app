package com.libraryapp;

import jakarta.persistence.PostUpdate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/books")
public class Main {

    public Main(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    record NewBookRequest(
            String author,
            Boolean availability,
            String title
    ) {
    }
    @PostMapping
    public void addBook(@RequestBody NewBookRequest request) {
        Book book = new Book();
        book.setAvailability(request.availability);
        book.setAuthor(request.author);
        book.setTitle(request.title);
        bookRepository.save(book);
    };

    @DeleteMapping("{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @PutMapping("{bookId}")
    public void updateBook(@PathVariable("bookId") Integer bookId,
                           @RequestBody NewBookRequest request) {
        Book bookUpdated = bookRepository.getById(bookId);
        bookUpdated.setAvailability(request.availability);
        bookUpdated.setAuthor(request.author);
        bookUpdated.setTitle(request.title);
        bookRepository.save(bookUpdated);

    }
}
