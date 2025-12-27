package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookId;
  
  @Column(nullable = false)
  private String title;
  
  @Column(nullable = false)
  private String author;
  
  @Column(nullable = false)
  private Boolean available;
  
  @ManyToOne
  @JoinColumn(name = "category_id")
  private BookCategory bookCategory;

  public Book() {}

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public void setAuthor(String author) {
    this.author = author;
  }
  
  public Boolean getAvailable() {
    return available;
  }
  
  public void setAvailable(Boolean available) {
    this.available = available;
  }
  
  public BookCategory getBookCategory() {
    return bookCategory;
  }
  
  public void setBookCategory(BookCategory bookCategory) {
    this.bookCategory = bookCategory;
  }
}

