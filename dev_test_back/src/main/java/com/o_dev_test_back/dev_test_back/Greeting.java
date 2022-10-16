package com.o_dev_test_back.dev_test_back;

public class Greeting {

  private final long id;
  private final String name;
  private final int age;

  public Greeting(long id, String personName, int personAge) {
    this.id = id;
    this.name = personName;
    this.age = personAge;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
