package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Orders;
import com.ambow.springboot.mapper.OrdersMapper;
import com.ambow.springboot.service.OrdersService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    private List<Orders> listorderByDay;
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
    public Page<Orders> toListOrders(Integer page, Integer rows, Integer state) {

        Orders orders = new Orders();

        orders.setStart((page - 1) * rows);
        orders.setRows(rows);
        orders.setState(state);
        List<Orders> ordersList = ordersMapper.toListOrders(orders);
        Integer count = ordersMapper.selectOrdersCount(orders);
        Page<Orders> pages = new Page<Orders>();
        pages.setPage(page);
        pages.setRows(ordersList);
        pages.setSize(rows);
        pages.setTotal(count);
        return pages;
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

    /*
    * 区间内的日销量
    * */
    @Override
    public List<Report> ordersDay(String time1, String time2) {
        return ordersMapper.ordersDay(time1,time2);
    }

    @Override
    public List<Report> ordersMonth(String year) {
        return ordersMapper.ordersMonth(year);
    }


    @Override
    public List<Orders> likeListOrder() {
        Orders order=new Orders();

        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
            String nowdates=sdfs.format(c.getTime());
            listorderByDay=ordersMapper.likeListOrders(nowdates);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listorderByDay;
    }


    /*
    *菜品销售量
    * */
    @Override
    public List<Report> goodsSale() {
        return ordersMapper.goodsSale();
    }

    /*
    * 某一天的时间客流量
    * */
    @Override
    public List<Report> hoursCustmer(String time1) {
        return ordersMapper.hoursCustmer(time1);
    }
    /*
    * 时间段的天收入
    * */
    @Override
    public List<Report> costGain(String time1,String time2) {
        return ordersMapper.costGain(time1,time2);
    }
    /*
    * 时间段的月收入
    *
    * */
    @Override
    public List<Report> costGainMonth(String time1) {
        return ordersMapper.costGainMonth(time1);
    }

    /*
    * 年利润
    * */
    @Override
    public List<Report> costGainYear() {
        return ordersMapper.costGainYear();
    }

    /*
    * 根据用户id查找订单
    * */
    @Override
    public List<Orders> findOrdersByUserId(Integer id) {
        return ordersMapper.findOrdersByUserId(id);
    }


    /*
    * 退菜根据订单号修改价钱
    * */
    @Override
    public void updateOrdersPrice(Integer xiaoji, Long orderNum) {
        ordersMapper.updateOrdersPrice(xiaoji,orderNum);
    }
}
