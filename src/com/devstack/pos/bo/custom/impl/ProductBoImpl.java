package com.devstack.pos.bo.custom.impl;

import com.devstack.pos.bo.custom.ProductBo;
import com.devstack.pos.dto.ProductDto;

import java.util.List;

public class ProductBoImpl implements ProductBo {
    @Override
    public boolean saveProduct(ProductDto dto) {
        return false;
    }

    @Override
    public boolean updateProduct(ProductDto dto) {
        return false;
    }

    @Override
    public boolean deleteProduct(int code) {
        return false;
    }

    @Override
    public ProductDto findProduct(int code) {
        return null;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return null;
    }
}
