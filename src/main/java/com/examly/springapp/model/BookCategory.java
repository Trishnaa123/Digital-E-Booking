package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_categories")
public class BookCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;

  @Column(name = "category_name", nullable = false)
  private String categoryName;

  public BookCategory() {}

  public BookCategory(String categoryName) {
    this.categoryName = categoryName;
  }

  public Long getCategoryId() { return categoryId; }
  public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

  public String getCategoryName() { return categoryName; }
  public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}


