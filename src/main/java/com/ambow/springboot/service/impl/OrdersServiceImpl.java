package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Orders;
import com.ambow.springboot.mapper.OrdersMapper;
import com.ambow.springboot.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    /*
    * 添加订单
    * */
    @Override
    public void toSave(Orders orders) {
        ordersMapper.insert(orders);
    }


    /*
    * 根据订单号查询所有订单
    * */
    @Override
    public Orders toListOrdersByOrderNum(Long order_number) {
        return ordersMapper.toListOrdersByOrderNum(order_number);
    }

    /*
    * 查询所有订单
    * */
    @Override
    public List<Orders> toListOrders() {
        return ordersMapper.toListOrders();
    }

    /*
    * 网上支付修改状态为1
    * */
    @Override
    public void toUpdateUp(Long orders_num) {
        ordersMapper.toUpdateUp(orders_num);
    }

    /*
     * 线下支付修改状态为2
     * */
    @Override
    public void toUpdateDown(Long orders_num) {
        ordersMapper.toUpdateDown(orders_num);
    }
}
