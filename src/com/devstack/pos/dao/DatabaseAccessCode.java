package com.devstack.pos.dao;

import com.devstack.pos.db.DbConnection;
import com.devstack.pos.dto.CustomerDto;
import com.devstack.pos.dto.UserDto;
import com.devstack.pos.util.PasswordManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessCode {


    //====Customer management===============
    public static List<CustomerDto> searchCustomers(String searchText) throws ClassNotFoundException, SQLException {

        searchText = "%" + searchText + "%";

        String sql = "SELECT * FROM customer WHERE email LIKE ? || name LIKE ?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, searchText);
        preparedStatement.setString(2, searchText);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<CustomerDto> dtos = new ArrayList<>();
        while (resultSet.next()) {
            dtos.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }
        return dtos;
    }
    //====Customer management===============

    //====Product management===============
    public static int getLastProductId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM product ORDER BY code DESC LIMIT 1";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return (resultSet.getInt(1)+1);
        }
        return 1;
    }


    //====Product management===============

}
