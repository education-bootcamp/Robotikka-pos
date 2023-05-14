package com.devstack.pos.dao;

import com.devstack.pos.dao.custom.impl.*;
import com.devstack.pos.enums.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public <T> T getDao(DaoType daoType) {
        switch (daoType) {
            case USER:
                return (T) new UserDaoImpl();
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case PRODUCT:
                return (T) new ProductDaoImpl();
            case PRODUCT_DETAIL:
                return (T) new ProductDetailDaoImpl();
            case ITEM_DETAIL:
                return (T) new ItemDetailDaoImpl();
            case ORDER_DETAIL:
                return (T) new OrderDetailDaoImpl();
            default:
                return null;
        }
    }


}
