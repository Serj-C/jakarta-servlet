package org.example.beans;

import org.example.database.PostgreSqlConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorBean implements Serializable {
    private static final Logger logger = Logger.getLogger(AuthorBean.class.getName());
    public List<Author> authorList;

    public AuthorBean() {
    }

    public List<Author> getAuthorList() {
        authorList = queryAuthors();
        System.out.println("authorList: " + authorList);
        return authorList;
    }

    private List<Author> queryAuthors() {
        String sql = """
                SELECT ID, FIRSTNAME, LASTNAME
                FROM AUTHORS""";
        authorList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        int result = -1;

        try {
            PostgreSqlConnection postgreSqlConnection = new PostgreSqlConnection();
            Connection connection = postgreSqlConnection.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("executing statement");
            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getInt("ID"));
                author.setFirst(resultSet.getString("FIRSTNAME"));
                author.setLast(resultSet.getString("LASTNAME"));
                authorList.add(author);
                System.out.println("Got author: " + author);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, null, e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, null, e);
                }
            }
        }

        return authorList;
    }
}
