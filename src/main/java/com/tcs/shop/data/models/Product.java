package com.tcs.shop.data.models;

import java.math.BigDecimal;

public class Product {

  private int id;
  private String name;
  private BigDecimal price;

  public Product(int id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Product(String name, BigDecimal price) {
    this(0, name, price);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return String.format("[%d] %s $%s", id, name, price);
  }

}
