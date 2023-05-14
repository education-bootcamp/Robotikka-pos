package com.devstack.pos.dao.custom.impl;

import com.devstack.pos.dao.CrudUtil;
import com.devstack.pos.dao.custom.ProductDetailDao;
import com.devstack.pos.entity.ProductDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailDaoImpl implements ProductDetailDao {
    @Override
    public boolean save(ProductDetail productDetail) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "INSERT INTO product_detail VALUES (?,?,?,?,?,?,?,?)",
                productDetail.getCode(),
                productDetail.getBarcode(),
                productDetail.getQtyOnHand(),
                productDetail.getSellingPrice(),
                productDetail.isDiscountAvailability(),
                productDetail.getShowPrice(),
                productDetail.getProductCode(),
                productDetail.getBuyingPrice()
        );
    }

    @Override
    public boolean update(ProductDetail productDetail) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ProductDetail find(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<ProductDetail> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<ProductDetail> findAllProductDetails(int productCode) throws SQLException, ClassNotFoundException {
       ResultSet set= CrudUtil.execute("SELECT * FROM product_detail WHERE product_code=?", productCode);
       List<ProductDetail> list = new ArrayList<>();
        while (set.next()){
            list.add(new ProductDetail(
                    set.getString(1),set.getString(2),
                    set.getInt(3),set.getDouble(4),
                    set.getDouble(6),set.getDouble(8),
                    set.getInt(7),
                    set.getBoolean(5)
            ));
        }
        return list;
    }
}
