package com.devstack.pos.bo.custom;

import com.devstack.pos.dto.ProductDto;

import java.sql.SQLException;
import java.util.List;

public interface ProductBo {
    public boolean saveProduct(ProductDto dto) throws SQLException, ClassNotFoundException;
    public boolean updateProduct(ProductDto dto);
    public boolean deleteProduct(int code);
    public ProductDto findProduct(int code);
    public List<ProductDto> findAllProducts();
    public int getLastProductId() throws SQLException, ClassNotFoundException;
}
