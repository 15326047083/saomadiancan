package com.ambow.springboot;

import com.ambow.springboot.mapper.OrdersMapper;
import com.ambow.springboot.mapper.PurchaseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PurchaseMapper purchaseMapper;


    //区间内的天销量
    @Test
    public void ordersDay(){
        String time1="2018-09-04";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String time2="2018-09-06";
        System.out.println(ordersMapper.ordersDay(time1,time2));
    }

    //某一年的月销量
    @Test
    public void ordersMonth(){

        String year="2018";
        System.out.println(ordersMapper.ordersMonth(year));
    }

    //菜品销售量
    @Test
    public void goodsSales(){

        System.out.println(ordersMapper.goodsSale());
    }
    //时段客流量
    @Test
    public void hoursCustmer(){
        System.out.println(ordersMapper.hoursCustmer("2018-09-05"));
    }
    //日成本利润
    @Test
    public void costGain(){
        System.out.println(ordersMapper.costGain("2018-09-05","2018-09-09"));
    }

    //月成本利润
    @Test
    public void costGainMonth(){
        System.out.println(ordersMapper.costGainMonth("2018-08","2018-09"));
    }

}
