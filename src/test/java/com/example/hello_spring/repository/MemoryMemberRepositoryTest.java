package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
  // 테스트 코드를 작성할때는
  // 메서드 순서와 관계없이 서로 의존관계를 형성하지 않도록 작성해야한다.
  // 즉, 그 메서드 안에서만 해당 테스트 코드가 작동하도도록 해야한다.
  // TDD : 테스트 코드를 먼저 만들어보고 그 후에 코드를 작성
  MemoryMemberRepository repository = new MemoryMemberRepository();
  @AfterEach // 메서드가 실행
  public void afterEach(){
    repository.clearStore();
  }

  @Test
  public void save(){
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();

//    System.out.println("result = " + (result == member));
//    Assertions.assertEquals(member, result);

    // member가 result랑 같은면
    assertThat(member).isEqualTo(result);
//    assertThat(member).isEqualTo(null);

  }

  @Test
  public void findByName(){
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring1");
    repository.save(member2);


    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);


  }

  @Test
  public void findAll(){
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring1");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);

  }



}
