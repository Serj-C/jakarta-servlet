package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSqlConnection {

    public Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/mydb";
            String user = "postgres";
            String password = "<toBeProvided>";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL server successfully.");
        } catch (SQLException e) {
            Logger.getLogger(PostgreSqlConnection.class.getName()).log(Level.SEVERE, null, e);
        }

        return connection;
    }
}
