package com.examly.springapp.controller;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

  private final BookCategoryService service;

  public BookCategoryController(BookCategoryService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<BookCategory> addCategory(@RequestBody BookCategory category) {
    if (category.getCategoryName() == null || category.getCategoryName().isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.status(201).body(service.addCategory(category));
  }

  @GetMapping
  public ResponseEntity<List<BookCategory>> getAllCategories() {
    List<BookCategory> categories = service.getAllCategories();
    if (categories.isEmpty()) return ResponseEntity.noContent().build();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookCategory> getCategoryById(@PathVariable Long id) {
    return service.getCategoryById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.status(404)
            .body(new BookCategory("Book category not found")));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BookCategory> updateCategory(@PathVariable Long id, @RequestBody BookCategory category) {
    try {
      return ResponseEntity.ok(service.updateCategory(id, category));
    } catch (RuntimeException e) {
      return ResponseEntity.status(404).body(new BookCategory("Book category not found"));
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    if (service.getCategoryById(id).isPresent()) {
      service.deleteCategory(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/page/{page}/{size}")
  public ResponseEntity<Page<BookCategory>> getCategoriesWithPagination(@PathVariable int page, @PathVariable int size) {
    return ResponseEntity.ok(service.getCategoriesWithPagination(page, size));
  }
}


