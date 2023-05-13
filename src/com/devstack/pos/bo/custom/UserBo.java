package com.devstack.pos.bo.custom;

import com.devstack.pos.dto.UserDto;

import java.util.List;

public interface UserBo {
    public boolean saveUser(UserDto dto);
    public boolean updateUser(UserDto dto);
    public boolean deleteUser(String email);
    public UserDto findUser(String email);
    public List<UserDto> findAllUsers();
}
