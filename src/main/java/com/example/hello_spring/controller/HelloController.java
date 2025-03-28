package com.example.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("hello")
  public String hello(Model model){
    model.addAttribute("data","helllll!!!!!o");

  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam(value = "name") String name, Model model){
    model.addAttribute("name",name);
    return "hello-template";
  }

  @GetMapping("hello-string")
  @ResponseBody  // 이건 http에서 바디에 이 데이터를 내가 넣어주겠다.
  public String helloString(@RequestParam(value = "name") String name){
    return "hello " + name; // "hello kim"
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name){
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
  }


  static class Hello{
    private String name;
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
  }
}
