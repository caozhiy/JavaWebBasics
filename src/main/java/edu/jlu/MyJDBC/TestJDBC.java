package edu.jlu.MyJDBC;

import java.sql.*;


public class TestJDBC {
    public static void main(String[] args) {
            first();
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
