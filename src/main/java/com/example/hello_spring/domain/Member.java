package com.example.hello_spring.domain;

import jakarta.persistence.*;

@Entity // jpa가 관리하는 엔티티가 된다.
public class Member {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 디비컬러명이랑 달라도 이런식으로 매핑 가능 @Column(name = "username")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
