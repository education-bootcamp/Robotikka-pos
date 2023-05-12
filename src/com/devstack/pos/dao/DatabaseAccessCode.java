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
    public static boolean createCustomer(String email, String name, String contact, double salary) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO customer VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, contact);
        preparedStatement.setDouble(4, salary);
        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean updateCustomer(String email, String name, String contact, double salary) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE customer SET name=?, contact=?, salary=? WHERE email=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, contact);
        preparedStatement.setDouble(3, salary);
        preparedStatement.setString(4, email);
        return preparedStatement.executeUpdate() > 0;
    }

    public static CustomerDto findCustomer(String email) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer WHERE email=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            );
        }
        return null;
    }

    public static boolean deleteCustomer(String email) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Customer WHERE email=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, email);
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<CustomerDto> findAllCustomers() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM customer";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
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

    public static boolean saveProduct(int code, String description) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO product VALUES(?,?)";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,code);
        preparedStatement.setString(2,description);
        return preparedStatement.executeUpdate() > 0;
    }

    //====Product management===============

}
