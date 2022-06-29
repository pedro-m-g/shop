package com.tcs.shop.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tcs.shop.data.models.Product;

public class ProductDAO {

  private Connection connection;

  public ProductDAO(Connection connection) {
    this.connection = connection;
  }

  public void registerProduct(Product product) throws SQLException {
    String query = "INSERT INTO products (name, price) VALUES (?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, product.getName());
      statement.setBigDecimal(2, product.getPrice());
      statement.executeUpdate();
    }
  }

}