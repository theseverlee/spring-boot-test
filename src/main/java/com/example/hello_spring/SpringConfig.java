package com.example.hello_spring;

import com.example.hello_spring.repository.MemberRepository;
import com.example.hello_spring.repository.MemoryMemberRepository;
import com.example.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
//    return new DbMemberRepository();  // 추후 변경
    return new MemoryMemberRepository();
  }

}
