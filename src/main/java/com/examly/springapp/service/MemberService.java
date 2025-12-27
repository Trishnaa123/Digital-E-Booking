package com.examly.springapp.service;

import com.examly.springapp.model.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {
  Member addMember(Member member);
  List<Member> getAllMembers();
  Optional<Member> getMemberById(Long id);
  Member updateMember(Long id, Member member);
  void deleteMember(Long id);
  List<Member> getMembersByPhone(String phone);
  List<Member> getMembersByEmail(String email);
}


