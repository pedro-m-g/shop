package com.tcs.shop.data.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

  public List<Product> listProducts() throws SQLException {
    String query = "SELECT * FROM products";
    try (
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query)
    ) {
      List<Product> products = new ArrayList<>();
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        BigDecimal price = rs.getBigDecimal("price");

        Product product = new Product(id, name, price);
        products.add(product);
      }
      return products;
    }
  }

}
