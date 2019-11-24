package com.example.mobileapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/mobile";
   //?useSSL=false&allowPublicKeyRetrieval=true

   static final String USER = "root";
   static final String PASS = "minji1106";

   Connection conn = null;
   Statement stmt = null;

   public DBConnect() {
       try {
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
