package com.example.hello_spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Optional;

public class OnlyJustTest {

  public void mapValuesTest (String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Apple", 100);
    map.put("Banana", 200);
    map.put("Cherry", 300);

    // values() 사용
    Collection<Integer> values = map.values();

    // 출력
    System.out.println(values); // [100, 200, 300]

    // 변경 사항 반영 확인
    map.put("Durian", 400);
    System.out.println(values); // [100, 200, 300, 400]
  }


  public static void lamdaFindAnyTest() {
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
    System.out.println(names);
    // ✅ "C"로 시작하는 아무 이름이나 찾기
    Optional<String> name = names.stream()
        .filter(n -> n.startsWith("C"))
        .findAny();

    // 결과 출력
    name.ifPresent(System.out::println);  // "Charlie"

  }

  public static void main(String[] args) {
    lamdaFindAnyTest();
  }
}
