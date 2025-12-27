package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

  @GetMapping("/{id}")
  public String getBorrow(@PathVariable Long id) {
    return "Borrow";
  }
}


