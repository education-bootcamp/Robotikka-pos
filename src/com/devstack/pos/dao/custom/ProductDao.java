package com.devstack.pos.dao.custom;

import com.devstack.pos.entity.Customer;
import com.devstack.pos.entity.Product;

import java.util.List;

public interface ProductDao {
    public boolean saveProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(int code);
    public Product findProduct(int code);
    public List<Product> findAllProducts();
}
