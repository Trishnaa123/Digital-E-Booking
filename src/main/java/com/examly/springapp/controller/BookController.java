package com.examly.springapp.controller;

import com.examly.springapp.model.Book;
import com.examly.springapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    Book savedBook = bookService.addBook(book);
    return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookService.getAllBooks();
    return ResponseEntity.ok(books);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable Long id) {
    return bookService.getBookById(id)
        .map(book -> ResponseEntity.ok(book))
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
    try {
      Book updatedBook = bookService.updateBook(id, book);
      return ResponseEntity.ok(updatedBook);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/category/{categoryName}")
  public ResponseEntity<List<Book>> getBooksByCategoryName(@PathVariable String categoryName) {
    List<Book> books = bookService.getBooksByCategoryName(categoryName);
    return ResponseEntity.ok(books);
  }

  @GetMapping("/title/{title}")
  public ResponseEntity<Object> getBooksByTitle(@PathVariable String title) {
    List<Book> books = bookService.getBooksByTitle(title);
    if (books.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book found with title: " + title);
    }
    return ResponseEntity.ok(books);
  }
}


