package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface BookCategoryService {
  BookCategory addCategory(BookCategory category);
  List<BookCategory> getAllCategories();
  Optional<BookCategory> getCategoryById(Long id);
  BookCategory updateCategory(Long id, BookCategory category);
  void deleteCategory(Long id);
  Page<BookCategory> getCategoriesWithPagination(int page, int size);
}
