package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Orders;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.Report;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
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
    List<Orders> toListOrders(Orders orders);
    /*
    * 网上支付修改状态
    * */
    void toUpdateUp(@PathVariable("orders_num") Long orders_num);
    /*
     * 线下支付修改状态
     * */
    void toUpdateDown(Long orders_num);
    /*
    * 查看订单总数
    * */
    Integer selectOrdersCount(Orders orders);

    /*
    * 区间内的日销量
    * */
    List<Report> ordersDay(@Param("time1") String time1, @Param("time2") String time2);

    /*
    * 某年的月销量
    * */
    List<Report> ordersMonth(@Param("year") String year);

    /*
     * 根据日期区间查询所有订单
     * */
    List<Orders> likeListOrders(@Param("time1") String time1);

    /*
    * 菜品的销售量
    * */

    List<Report> goodsSale();
}