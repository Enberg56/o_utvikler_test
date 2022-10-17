package com.o_dev_test_back.dev_test_back;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  // Husk frontend ip i crossorigin
  @CrossOrigin(origins = "http://localhost:5173")
  @GetMapping("/")
  public List<User> userList() {
    List<User> result = new ArrayList<>();
    result.add(new User(1, "Frida", 22));
    result.add(new User(2, "Emil", 33));
    result.add(new User(2, "Kjell", 43));
    return result;
  }

}