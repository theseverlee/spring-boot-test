package com.example.hello_spring.service;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원가입
   */
  public Long join(Member member){
    // 같은 이름이 있는 중복 회원xx // 변수자동생성 단축키
//    Optional<Member> result = memberRepository.findByName(member.getName());
//    // optional 바로 꺼내쓰지 말고
//
//    result.ifPresent(m -> {
//      throw new IllegalStateException("이미 존재하는 회원입니다.");
//    });

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
