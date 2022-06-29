package com.tcs.shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.tcs.shop.data.DataSource;
import com.tcs.shop.data.dao.ProductDAO;
import com.tcs.shop.data.models.Product;

/**
 * Hello world!
 *
 */
public class App
{

    private static final String DATABASE_PROPERTIES_FILE = "/database.properties";

    public static void main( String[] args )
    {
        Properties properties = new Properties();
        try {
            properties.load(App.class.getResourceAsStream(DATABASE_PROPERTIES_FILE));
        } catch (IOException e) {
            System.err.println("Could not read database configuration");
            System.exit(1);
        }
        try (Connection connection = DataSource.connect(properties)) {
            System.out.println("Connected successfully to database");

            ProductDAO productDAO = new ProductDAO(connection);
            /*
             * Product product = new Product("Pleishon 5", new BigDecimal("12000"));
             * productDAO.registerProduct(product);
             */

            List<Product> products = productDAO.listProducts();
            System.out.println(products);
        } catch (SQLException e) {
            System.err.println("Could not connect to database");
            System.exit(1);
        }
    }

}
