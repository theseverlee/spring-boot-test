package com.example.hello_spring.service;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional // 데이터를 저장을 할때는 JPA를 사용해야한다.
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원가입
   */
  public Long join(Member member){
    validateDuplicate(member);
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicate(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재한 회원입니다.");
        });
  }

  /**
   * 전체 회원 조회
   */
  public List<Member> findMember(){
    return memberRepository.findAll();
  }


  /**
   * id 찾기
   */
  public Optional<Member> findOne(Long memberId){
    return memberRepository.findById(memberId);
  }

}
