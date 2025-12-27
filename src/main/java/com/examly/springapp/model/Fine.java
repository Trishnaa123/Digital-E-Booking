package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fine {

  @Id
  private Long id;
  private Double amount;

  public Fine() {}

  public Long getId() {
    return id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}

