package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
  Book addBook(Book book);
  List<Book> getAllBooks();
  Optional<Book> getBookById(Long id);
  Book updateBook(Long id, Book book);
  void deleteBook(Long id);
  List<Book> getBooksByCategoryName(String categoryName);
  List<Book> getBooksByTitle(String title);
}


