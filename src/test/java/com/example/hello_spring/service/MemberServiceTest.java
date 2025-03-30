package com.example.hello_spring.service;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

  MemberService memberService;
  // 클리어용 작성
  MemoryMemberRepository memberRepository;

  @BeforeEach // 각 테스트를 사용하기 전에 생성해준다
  public void beforeEach(){ // DI 의존성 주입
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach(){
    memberRepository.clearStore();
  }


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
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//    assertThrows(NullPointerException.class, () -> memberService.join(member2));
    assertThat(e.getMessage()).isEqualTo("이미 존재한 회원입니다.");

//    try {
//      memberService.join(member2);
////      fail();
//    } catch (IllegalStateException e){
//      assertThat(e.getMessage()).isEqualTo("이미 존해하는 회원입니다.");
//    }

    //then

  }


  @Test
  void findMember() {
  }

  @Test
  void findOne() {
  }
}