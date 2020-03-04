package kz.greetgo.sandbox.controller.model;

//TODO PHONE a не PHONES
public class Phones {
  public String id;
  public String number;
  public PhoneType type;

  public Phones() {
  }

  public Phones(String id, String number, PhoneType type) {
    this.id = id;
    this.number = number;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public PhoneType getType() {
    return type;
  }

  public void setType(PhoneType type) {
    this.type = type;
  }

}
