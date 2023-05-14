package com.devstack.pos.bo.custom;

import com.devstack.pos.dto.OrderDetailDto;

public interface OrderDetailBo {
    public boolean makeOrder(OrderDetailDto d);
}
