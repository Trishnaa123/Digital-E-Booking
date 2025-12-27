package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Borrow {

  @Id
  private Long id;
  private String status;

  public Borrow() {}

  public Long getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

