package com.devstack.pos.dao;

import com.devstack.pos.dto.UserDto;
import com.devstack.pos.util.PasswordManager;

import java.sql.*;

public class DatabaseAccessCode {
    public static boolean createUser(
            String email,String password
    ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/robotikka",
                "root","1234");
        String sql="INSERT INTO user VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, PasswordManager.encryptPassword(password));
        return preparedStatement.executeUpdate()>0;
    }

    public static UserDto findUser(String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/robotikka",
                "root", "1234");
        String sql = "SELECT * FROM user WHERE email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        ResultSet set = preparedStatement.executeQuery();
        if (set.next()){
            return new UserDto(
                    set.getString(1),
                    set.getString(2)
            );
        }
        return null;
    }

}
