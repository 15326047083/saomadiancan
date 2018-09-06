package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Orders;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /*
    * 根据订单号查询订单
    * */
    Orders toListOrdersByOrderNum(Long order_number);

    /*
    * 查询所有订单信息
    * */
    List<Orders> toListOrders();
    /*
    * 网上支付修改状态
    * */
    void toUpdateUp(@PathVariable("orders_num") Long orders_num);
    /*
     * 线下支付修改状态
     * */
    void toUpdateDown(Long orders_num);
}