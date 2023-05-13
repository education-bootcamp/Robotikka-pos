package com.devstack.pos.bo.custom;

import com.devstack.pos.dto.ProductDto;

import java.util.List;

public interface ProductBo {
    public boolean saveProduct(ProductDto dto);
    public boolean updateProduct(ProductDto dto);
    public boolean deleteProduct(int code);
    public ProductDto findProduct(int code);
    public List<ProductDto> findAllProducts();
}
