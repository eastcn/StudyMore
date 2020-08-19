package com.east.JavaBasic.JDBC;

import java.sql.*;

/**
 * @Classname demo
 * @Description JDBC demo
 * @Date 2020/8/19 10:25 上午
 * @Created by East
 */
public class demo {
    private final String jdbcUrl = "jdbc:mysql://172.16.84.83:3306/hefeng?useSSL=false&characterEncoding=utf8";
    private final String user = "root";
    private final String password = "root";

    public void get() throws SQLException {
        try (final Connection connection = DriverManager.getConnection(jdbcUrl, user, password);) {
            try (Statement statement = connection.createStatement()) {
                String sql = "select * from demo_datasource where id=3012";
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    long id = rs.getLong(1);
                    double x0 = rs.getDouble(2);
                    System.out.println("id:" + id + " x0:" + x0);
                }
                rs.close(); // 必须要关
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        demo d = new demo();
        d.get();
    }

}
