package edu.jlu.MyJDBC;

import lombok.Cleanup;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;


public class TestJDBC {
    public static void main(String[] args) {
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("TestMapper.xml")).getPath();
        System.out.println(path);


        try (InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestJDBC.properties")) {

            Properties properties = new Properties();
            try {
                properties.load(stream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println(properties.getProperty("classname"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //            first();
    }

    public static void first() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_hr", "root", "364390");
             Statement statement = connection.createStatement()) {

            // 测试executeQuery语句
            statement.executeQuery("select * from employees limit 20");
            ResultSet set = statement.getResultSet();
            while (set.next()) {
                System.out.println(String.join(" ",
                        set.getString(1), set.getString(2), set.getString(3)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
