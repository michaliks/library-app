package com.libraryapp.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class BooksController {
    private final BookRepository bookRepository;

    BooksController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    record NewBookRequest(
            String author,
            Boolean availability,
            String title
    ) {
    }

    @PostMapping("/books")
    public void addBook(@RequestBody BooksController.NewBookRequest request) {
        Book book = new Book();
        book.setAvailability(request.availability);
        book.setAuthor(request.author);
        book.setTitle(request.title);
        bookRepository.save(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    @PutMapping("/books/{bookId}")
    public void updateBook(@PathVariable("bookId") Integer bookId,
                           @RequestBody BooksController.NewBookRequest request) {
        Book bookUpdated = bookRepository.getById(bookId);
        bookUpdated.setAvailability(request.availability);
        bookUpdated.setAuthor(request.author);
        bookUpdated.setTitle(request.title);
        bookRepository.save(bookUpdated);
    }
}
