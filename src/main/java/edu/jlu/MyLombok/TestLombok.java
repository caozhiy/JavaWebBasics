package edu.jlu.MyLombok;

import lombok.Cleanup;

import java.sql.*;


public class TestLombok {

    private static final String URL = "jdbc:mysql://localhost:3306/sql_hr";
    private static final String user = "root";
    private static final String pwd = "364390";

    public static void main(String[] args) {
        first();
    }

    public static void first() {
        Office office = new Office(1, "03 Reinke Trail", "Cincinnati", "OH");
        Employee employee = new Employee(33391, "D'arcy", "Nortunen", "Account Executive", 62871, 37270, 1);
        System.out.println(office);
        System.out.println(employee);
        System.out.println(Office.getCount());
        Office.setCount(Office.getCount() + 1);


        try {
            @Cleanup
            Connection connection = DriverManager.getConnection(URL, user, pwd);

            @Cleanup
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT e1.employee_id                           Inferior,\n" +
                    "       CONCAT(e1.first_name, ' ', e1.last_name) Staff,\n" +
                    "       e2.employee_id                           Superior,\n" +
                    "       CONCAT(e2.first_name, ' ', e2.last_name) Boss\n" +
                    "FROM employees e1\n" +
                    "         left join employees e2 on e1.reports_to = e2.employee_id;");

            ResultSetMetaData metaData = statement.getResultSet().getMetaData();
            System.out.println(String.join(" ",
                    metaData.getColumnName(1),
                    metaData.getColumnName(2),
                    metaData.getColumnName(3),
                    metaData.getColumnName(4)));
            while (resultSet.next()) {
                String res = String.join(" ",
                        String.format("%-6s", resultSet.getString(1)),
                        String.format("%-20s", resultSet.getString(2)),
                        String.format("%-6s", resultSet.getString(3)),
                        String.format("%-20s", resultSet.getString(4)));
                System.out.println(res);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
