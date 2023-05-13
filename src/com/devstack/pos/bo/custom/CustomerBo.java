package com.devstack.pos.bo.custom;

import com.devstack.pos.dto.CustomerDto;

import java.util.List;

public interface CustomerBo {
    public boolean saveCustomer(CustomerDto dto);
    public boolean updateCustomer(CustomerDto dto);
    public boolean deleteCustomer(String email);
    public CustomerDto findCustomer(String email);
    public List<CustomerDto> findAllCustomers();
}
