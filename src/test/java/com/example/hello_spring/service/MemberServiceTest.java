package com.example.hello_spring.service;

import com.example.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

  MemberService memberService = new MemberService();


  @Test // 테스트는 과감하게 한글로 사용해도 된다. join 회원가입
  void 회원가입() {
    // given // 뭔가 주어젔을때
    Member member = new Member();
    member.setName("hello");

    // when // 실행했을때
    Long saveId = memberService.join(member);

    // then // 결과가 이게 나와야 해
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());

  }

  @Test
  public void 중복_회원_예외(){
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    //when
    memberService.join(member1);
    try {
      memberService.join(member2);
    } catch (IllegalStateException e){

    }

    //then

  }


  @Test
  void findMember() {
  }

  @Test
  void findOne() {
  }
}