package com.o_dev_test_back.dev_test_back;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/greeting")
  public String hello() {
    return "hello World";
  }
}
