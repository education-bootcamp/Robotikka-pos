package com.devstack.pos.dao.custom.impl;

import com.devstack.pos.dao.custom.ProductDao;
import com.devstack.pos.entity.Product;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int code) {
        return false;
    }

    @Override
    public Product findProduct(int code) {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return null;
    }
}
