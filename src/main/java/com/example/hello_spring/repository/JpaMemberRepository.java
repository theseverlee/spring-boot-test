package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

  private final EntityManager em; // 스프링 부트가 자동으로 짬뽕해서 EntityManager를 만들어준다.

  public JpaMemberRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public Member save(Member member) {
    em.persist(member); // persist 영구 저장하다
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    Member member = em.find(Member.class, id); // 조회할 타입과 식별자
    return Optional.ofNullable(member);
  }

  @Override
  public Optional<Member> findByName(String name) {
    List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
        .setParameter("name", name)
        .getResultList();
    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    // jpql 이라는 JPA 쿼리날리기
    // 객체를 대상으로 쿼리를 날리게 된다. Member Entity를 조회 해라. 객체 자체를 조회하는거다.
    List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
    return result;
  }
}
