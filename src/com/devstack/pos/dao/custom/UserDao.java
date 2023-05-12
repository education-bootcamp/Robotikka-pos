package com.devstack.pos.dao.custom;

import com.devstack.pos.entity.Customer;
import com.devstack.pos.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public boolean saveUser(User user) throws SQLException, ClassNotFoundException;
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException;
    public boolean deleteUser(String email) throws SQLException, ClassNotFoundException;
    public User findUser(String email) throws SQLException, ClassNotFoundException;
    public List<User> findAllUsers() throws SQLException, ClassNotFoundException;
}
