package com.ambow.springboot;

import com.ambow.springboot.mapper.OrdersMapper;
import com.ambow.springboot.mapper.PurchaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PurchaseMapper purchaseMapper;


    /*
     * 网上支付修改状态测试
     * */
    @Test
    public void toUpdateUp(){
        long orders_num=1234567898;
        ordersMapper.toUpdateUp(orders_num);
    }
    /*
     * 网上支付修改状态测试
     * */
    @Test
    public void toUpdateDown(){
        long orders_num=1234567898;
        ordersMapper.toUpdateDown(orders_num);
    }
    /*
    * 查询所有订单内容
    * */
    @Test
    public void toListorders(){
        //System.out.println(ordersMapper.toListOrders());

    }
    /*
     * 根据订单号查询订单
     * */
    @Test
    public void toListOrdersByOrderNum(){
        long orders_num=1234567898;
        System.out.println(ordersMapper.toListOrdersByOrderNum(orders_num));
    }

    /*
    * 查询中间表所有内容
    * */
    @Test
    public void toListPurchase(){
        long orders_num=1234567898;
        System.out.println(purchaseMapper.toListPurchaseByOrderNumber(orders_num));
    }

    @Test
    public void findOrdersByUserId(){
        long orders_num=1234567898;
        System.out.println(ordersMapper.findOrdersByUserId(1));
    }
}
