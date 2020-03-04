package kz.greetgo.sandbox.controller.model;

public class Charm {
  public String id;
  public String name;

  public Charm() {
  }

  public Charm(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
