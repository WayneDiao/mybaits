package com.wayne.mybatis.jdbc;

import java.sql.*;

/**
 * @Author: wayne
 * @Date: 2018/9/9
 * @Description: jdbc测试程序
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" +
                "mybaits?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=" +
                "false&useUnicode=true&characterEncoding=utf8&autoReconnect=true&" +
                "rewriteBatchedStatements=true", "root", "password");
        String sql = "select * from user where username = ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, "王五");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.toString());
        }

        if (!resultSet.isClosed()) {
            resultSet.close();
        }
        if (!statement.isClosed()) {
            statement.close();
        }
        if (!connection.isClosed()) {
            connection.close();
        }

    }
}
