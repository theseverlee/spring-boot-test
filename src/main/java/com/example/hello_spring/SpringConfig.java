package com.example.hello_spring;

import com.example.hello_spring.repository.*;
import com.example.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository);
    // 스프링데이터 JPA
  }

//  @Bean
//  public MemberRepository memberRepository(){
//    return new JdbcMemoryMemberRepository(dataSource);  // 추후 변경
    // 구현체만 바꿨는데도 잘 돌아간다.
    // 객체지향의 진짜 매력은
    // 인터페이스에서 구현체를 바꾸더라도 기존코드를 수정하지 않아도 되는점

//    return new JdbcTemplateMemberRepository(dataSource);  // 추후 변경
//    return new MemoryMemberRepository();

    // JPA버전
//    return new JpaMemberRepository(em); // 이놈은 EntityManager가 필요하다.

//  }

}
