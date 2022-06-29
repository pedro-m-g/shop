package com.tcs.shop.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

  private static Connection connection;

  private static final String DBMS_PROPERTY = "dbms";
  private static final String HOST_PROPERTY = "host";
  private static final String PORT_PROPERTY = "port";
  private static final String DATABASE_PROPERTY = "database";
  private static final String USER_PROPERTY = "user";
  private static final String PASSWORD_PROPERTY = "password";

  public static Connection connect(Properties properties) throws SQLException {
    if (connection == null) {
      String dbms = properties.getProperty(DBMS_PROPERTY);
      String host = properties.getProperty(HOST_PROPERTY);
      String port = properties.getProperty(PORT_PROPERTY);
      String database = properties.getProperty(DATABASE_PROPERTY);
      String url = "jdbc:" + dbms + "://" + host + ":" + port + "/" + database;

      String user = properties.getProperty(USER_PROPERTY);
      String password = properties.getProperty(PASSWORD_PROPERTY);

      connection = DriverManager.getConnection(url, user, password);
    }
    return connection;
  }

}
