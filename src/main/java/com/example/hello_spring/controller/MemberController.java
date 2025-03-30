package com.example.hello_spring.controller;

import com.example.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
  // 스프링 컨테이너라는 통이생기는데
  // 거기에 어노테이션 컨트롤러가 있으면 멤버컨트롤러라는 객채를 생성해서 스프링에 넣어둔다
  // 스프링이 관리한다

//  private final MemberService memberService = new MemberService();
  // new해서 사용하면 다른컨트롤러에서 멤버서비스를 사용할 수 있다.
  // 객채를 뉴 하면 별기능없고 하나만 생성하고 공유하면된다.
  // 위처럼 말고
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService){
    this.memberService = memberService;
  }

  // 스프링 빈 등록
  // 1.컴포넌트 스캔 : controller > service > repository 각 어노테이션 들어가면 컴포넌트 어노테이션이 붙어있음
  //                @Component 어노테이션이 있으면 자동으로 스프링 빈에 자동등록
  // 2.자바코드로 직접 스프링빈 등록
  //               SpringConfig 파일 생성해서 @Configuration 이랑 @Bean으로 설정해준다

  // DI
  // 필드주입     : @Autowired private final MemberService memberService;
  // 생성자 주입   : 말그대로 생성자
  // Setter 주입 : Setter로 주입 // 단점 : 누군가 컨트롤러 호출할때 public으로 노출되어야한다.
  // >>>> 제일 좋은건 ::: 생성자 주입임  // 의존관계가 변경되는 일은 거즘 없음





}
