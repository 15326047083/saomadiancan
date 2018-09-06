package com.ambow.springboot;
import com.ambow.springboot.entity.Buy;


import com.ambow.springboot.entity.User;
import com.ambow.springboot.mapper.BuyMapper;
import com.ambow.springboot.service.BuyService;

import com.ambow.springboot.service.UserService;

import com.ambow.springboot.util.SendMessage;
import org.apache.commons.httpclient.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class yyTest {
    @Autowired
    private BuyService buyService;
    @Autowired
    private BuyMapper buyMapper;
    @Autowired
    private UserService userService;

    /*
     * 查询所有测试
     * */
    @Test
    public void testQueryAll() {
        /*System.out.println(buyService.buyList());*/
        Buy buy = new Buy();
        buy.setRows(2);
        buy.setStart(1);
        System.out.println(buyMapper.listBuy(buy));
    }

    /*
     * 统计条数
     * */
    @Test
    public void textCount() {
        System.out.println(buyMapper.selectBuyCount());

    }

    /*
     * 删除测试
     * */
    @Test
    public void testdelete() {
        buyService.deleteBuy(7);

    }

    /*
     * 新增测试
     * */
    @Test
    public void testAdd() {
        Buy buy = new Buy();
        buy.setName("yddf");
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
    public void testdeletes() {
        Integer[] ids = {4, 5, 6};
        buyService.deleteAll(ids);

    }

    /*
     *用户登录测试
     * */
    @Test
    public void testLogin() {
        User user = new User();
        user.setPhone("123");
        user.setPassword("123");
        System.out.println(userService.login(user));
    }

    /*
     * 用户注册测试
     * */
    @Test
    public void testZhuce() {
        User user = new User();
        user.setPassword("11");
        user.setName("11");
        user.setPhone("11");
        user.setIntegral(100);
        userService.insert(user);
    }
    /*
    * 用户注册短信验证测试
    * */
    @Test
    public void sendme()throws HttpException, IOException {
        HttpServletRequest request=null;
        String phone="15848639533";
        HashMap<String, String> m = SendMessage.getMessageStatus(phone);

    }
}