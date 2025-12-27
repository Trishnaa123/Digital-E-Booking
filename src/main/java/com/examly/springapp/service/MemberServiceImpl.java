package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepo repository;

  public MemberServiceImpl(MemberRepo repository) {
    this.repository = repository;
  }

  @Override
  public Member addMember(Member member) {
    return repository.save(member);
  }

  @Override
  public List<Member> getAllMembers() {
    return repository.findAll();
  }

  @Override
  public Optional<Member> getMemberById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Member updateMember(Long id, Member member) {
    return repository.findById(id).map(existing -> {
      existing.setName(member.getName());
      existing.setPhone(member.getPhone());
      existing.setEmail(member.getEmail());
      return repository.save(existing);
    }).orElseThrow(() -> new RuntimeException("Member not found"));
  }

  @Override
  public void deleteMember(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<Member> getMembersByPhone(String phone) {
    return repository.findByPhone(phone);
  }

  @Override
  public List<Member> getMembersByEmail(String email) {
    return repository.findByEmail(email);
  }
}


