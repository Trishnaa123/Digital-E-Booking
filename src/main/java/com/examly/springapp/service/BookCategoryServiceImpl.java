package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

  private final BookCategoryRepository repository;

  public BookCategoryServiceImpl(BookCategoryRepository repository) {
    this.repository = repository;
  }

  @Override
  public BookCategory addCategory(BookCategory category) {
    return repository.save(category);
  }

  @Override
  public List<BookCategory> getAllCategories() {
    return repository.findAll();
  }

  @Override
  public Optional<BookCategory> getCategoryById(Long id) {
    return repository.findById(id);
  }

  @Override
  public BookCategory updateCategory(Long id, BookCategory category) {
    return repository.findById(id).map(existing -> {
      existing.setCategoryName(category.getCategoryName());
      return repository.save(existing);
    }).orElseThrow(() -> new RuntimeException("Book category not found"));
  }

  @Override
  public void deleteCategory(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Page<BookCategory> getCategoriesWithPagination(int page, int size) {
    return repository.findAll(PageRequest.of(page, size));
  }
}


