package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository{
  //인터페이스로 만들어마 놓으면 스프링부트가 이름을 찾아서
  // JpaRepository를 받고있으면 지들이 구현체를 만들어낸다. 그리고 스프링 빈에 등록해둔다.

  // select m from m Member m where m.name = ?
  @Override
  Optional<Member> findByName(String name); // 구현할게 없다.


}
