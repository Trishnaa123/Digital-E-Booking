package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import com.examly.springapp.repository.BookRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepo repository;

  public BookServiceImpl(BookRepo repository) {
    this.repository = repository;
  }

  @Override
  public Book addBook(Book book) {
    return repository.save(book);
  }

  @Override
  public List<Book> getAllBooks() {
    return repository.findAll();
  }

  @Override
  public Optional<Book> getBookById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Book updateBook(Long id, Book book) {
    return repository.findById(id).map(existing -> {
      existing.setTitle(book.getTitle());
      existing.setAuthor(book.getAuthor());
      existing.setAvailable(book.getAvailable());
      existing.setBookCategory(book.getBookCategory());
      return repository.save(existing);
    }).orElseThrow(() -> new RuntimeException("Book not found"));
  }

  @Override
  public void deleteBook(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<Book> getBooksByCategoryName(String categoryName) {
    return repository.findByBookCategoryCategoryName(categoryName);
  }

  @Override
  public List<Book> getBooksByTitle(String title) {
    return repository.findByTitle(title);
  }
}


