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
    void toUpdateUp(@PathVariable("orders_num") Long orders_num, @PathVariable("all_price") Integer all_price);

    // 修改状态没有用户登陆
    void updateStateNoUser(@Param("orders_num") Long orders_num, @Param("price") Integer price);

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

    /*
     * 某一天小时的客流量
     * */
    List<Report> hoursCustmer(@Param("time1") String time1);

    /*
     * 区间内的日成本利润
     * */
    List<Report> costGain(@Param("time1") String time1, @Param("time2") String time2);

    /*
     * 区间内的月收入
     * */
    List<Report> costGainMonth(@Param("time1") String time1);

    /*
     * 年收入
     * */
    List<Report> costGainYear();

    /*
     * 根据用户id查找订单
     * */
    List<Orders> findOrdersByUserId(Integer id);

    /*
     * 退菜修改钱
     * */
    void updateOrdersPrice(@Param("xiaoji") Integer xiaoji, @Param("ordersNum") Long orderNum);

    /*
     * 根据订单号删除订单
     * */
    void deleteByNum(@Param("ordersNum") Long ordersNum);

    /*
     * 根据订单号删除订单中间表
     * */
    void deletePurchaseByNum(@Param("ordersNum") Long ordersNum);
}