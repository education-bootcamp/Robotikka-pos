package com.devstack.pos.bo.custom.impl;

import com.devstack.pos.bo.custom.OrderDetailBo;
import com.devstack.pos.dao.DaoFactory;
import com.devstack.pos.dao.custom.OrderDetailDao;
import com.devstack.pos.dto.OrderDetailDto;
import com.devstack.pos.enums.DaoType;

public class OrderDetailBoImpl implements OrderDetailBo {

    OrderDetailDao dao = DaoFactory.getInstance().getDao(DaoType.ORDER_DETAIL);

    @Override
    public boolean makeOrder(OrderDetailDto d) {
       //******************************

       //******************************
    }
}
