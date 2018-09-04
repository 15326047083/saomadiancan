package com.ambow.springboot;
import com.ambow.springboot.entity.Buy;


import com.ambow.springboot.service.BuyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class yyTest {
    @Autowired
    private BuyService buyService;

    /*
    * 查询所有测试
    * */
    @Test
    public void testQueryAll() {
        /*System.out.println(buyService.buyList());*/
        List<Buy>  list=buyService.buyList();
        System.out.println("dddddd"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(list.get(0).getBuyDate()));
    }
    /*
     * 删除测试
     * */
    @Test
    public void testdelete(){
        buyService.deleteBuy(1);

    }
    /*
    * 新增测试
    * */
    @Test
    public void testAdd(){
        Buy buy=new Buy();
        buy.setName("yy");
        buy.setNum("5");
        buy.setInfo("d");
        buy.setBuyDate(new Date());
        buy.setPrice(22);
        buy.setUserId(1);
        buyService.insertBuy(buy);
    }
    /*
     *批量删除测试
     * */
    @Test
    public void testdeletes(){
        Integer[] ids={4,5,6};
        buyService.deleteAll(ids);

    }
}
