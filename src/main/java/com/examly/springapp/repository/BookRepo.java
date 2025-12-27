package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.examly.springapp.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
  List<Book> findByBookCategoryCategoryName(String categoryName);
  List<Book> findByTitle(String title);
}

