package com.enn;


import org.junit.Test;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppTest {

    @Test
    public void testGetDriverManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Assert.notNull(connection);
    }

}
