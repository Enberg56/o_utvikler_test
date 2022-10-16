package com.o_dev_test_back.dev_test_back;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private final AtomicLong counter = new AtomicLong();

  // Husk frontend ip i crossorigin
  @CrossOrigin(origins = "http://127.0.0.1:5173/")
  @GetMapping("/")
  public List<Greeting> greeting() {
    List<Greeting> result = new ArrayList<>();
    result.add(new Greeting(counter.incrementAndGet(), "Ulrik", 22));
    result.add(new Greeting(counter.incrementAndGet(), "Emil", 33));
    return result;
  }
}