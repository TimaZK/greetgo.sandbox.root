package kz.greetgo.sandbox.controller.model;

public class Address {
  public String street;
  public int house;
  public int flat;
  public AddressType type;

  public Address(String street, int house, int flat, AddressType type) {
    this.street = street;
    this.house = house;
    this.flat = flat;
    this.type = type;
  }

  public Address() {
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getHouse() {
    return house;
  }

  public void setHouse(int house) {
    this.house = house;
  }

  public int getFlat() {
    return flat;
  }

  public void setFlat(int flat) {
    this.flat = flat;
  }

  public AddressType getType() {
    return type;
  }

  public void setType(AddressType type) {
    this.type = type;
  }
}
