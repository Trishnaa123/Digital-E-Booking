package com.examly.springapp.controller;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

  private final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping
  public ResponseEntity<Member> addMember(@RequestBody Member member) {
    Member savedMember = memberService.addMember(member);
    return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Member>> getAllMembers() {
    List<Member> members = memberService.getAllMembers();
    return ResponseEntity.ok(members);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
    return memberService.getMemberById(id)
        .map(member -> ResponseEntity.ok(member))
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
    try {
      Member updatedMember = memberService.updateMember(id, member);
      return ResponseEntity.ok(updatedMember);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
    memberService.deleteMember(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/phone/{phone}")
  public ResponseEntity<?> getMembersByPhone(@PathVariable String phone) {
    List<Member> members = memberService.getMembersByPhone(phone);
    if (members.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No member found with phone: " + phone);
    }
    return ResponseEntity.ok(members);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<List<Member>> getMembersByEmail(@PathVariable String email) {
    List<Member> members = memberService.getMembersByEmail(email);
    return ResponseEntity.ok(members);
  }
}


