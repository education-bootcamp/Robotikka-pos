package com.devstack.pos.bo.custom.impl;

import com.devstack.pos.bo.custom.ProductDetailBo;
import com.devstack.pos.dao.DaoFactory;
import com.devstack.pos.dao.custom.ProductDetailDao;
import com.devstack.pos.dto.ProductDetailDto;
import com.devstack.pos.entity.ProductDetail;
import com.devstack.pos.enums.DaoType;

import java.sql.SQLException;

public class ProductDetailBoImpl implements ProductDetailBo {
    ProductDetailDao dao= DaoFactory.getInstance().getDao(DaoType.PRODUCT_DETAIL);
    @Override
    public boolean saveProductDetail(ProductDetailDto dto) throws SQLException, ClassNotFoundException {
        return dao.save(
                new ProductDetail(
                        dto.getCode(), dto.getBarcode(), dto.getQtyOnHand(), dto.getSellingPrice(),
                        dto.getShowPrice(), dto.getBuyingPrice(), dto.getProductCode(),
                        dto.isDiscountAvailability()
                )
        );
    }
}
