package com.ambow.springboot.service;

import com.ambow.springboot.entity.Orders;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.Report;

import java.util.List;

public interface OrdersService {
    void toSave(Orders orders);

    Orders toListOrdersByOrderNum(Long order_number);

    Page<Orders> toListOrders(Integer page, Integer rows, Integer state);

    void toUpdateUp(Long orders_num);

    void toUpdateDown(Long orders_num);

    List<Report> ordersDay(String time1, String time2);

    List<Report> ordersMonth(String year);

    List<Orders> likeListOrder();

    List<Report> goodsSale();

    List<Report> hoursCustmer(String time1);

    List<Report> costGain(String time1,String time2);

    List<Report> costGainMonth(String time1);

    List<Report> costGainYear();

    List<Orders> findOrdersByUserId(Integer id);

    void updateOrdersPrice(Integer xiaoji, Long orderNum);
}
