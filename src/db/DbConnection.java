package db;

import constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    Constants.url,
                    Constants.username,
                    Constants.password);
            return connection;
        }catch (Exception e) {
            System.out.println("Connection to database error "+e);
        }
        return null;

    }
    public static void main(String[] args) {
        DbConnection.getConnection();
    }
}
