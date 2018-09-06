package com.ambow.springboot.service;

import com.ambow.springboot.entity.Orders;

import java.util.List;

public interface OrdersService {
    void toSave(Orders orders);

    Orders toListOrdersByOrderNum(Long order_number);

    List<Orders> toListOrders();

    void toUpdateUp(Long orders_num);

    void toUpdateDown(Long orders_num);
}
