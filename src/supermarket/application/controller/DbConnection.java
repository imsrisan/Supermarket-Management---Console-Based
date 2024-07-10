package supermarket.application.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/supermart";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sri@0606";

    // Singleton instance
    private static Connection con;

    // Connection object
//    private Connection con;

    // Private constructor to prevent instantiation from outside
    private DbConnection() {
        try {
            // Create a connection to the database
            con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
            //e.printStackTrace();
        }
    }

    // Method to get the singleton instance
    public static Connection getConnection() {
        if (con == null) {
            new DbConnection();
        }
        return con;
    }

    // Method to get the connection
//    public static Connection getConnection() {
//        return con;
//    }
}

