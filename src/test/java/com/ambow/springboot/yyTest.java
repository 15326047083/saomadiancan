package com.ambow.springboot;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ambow.springboot.entity.Buy;


import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.entity.Orders;
import com.ambow.springboot.entity.User;
import com.ambow.springboot.mapper.BuyMapper;
import com.ambow.springboot.mapper.OrdersMapper;
import com.ambow.springboot.service.BuyService;


import com.ambow.springboot.service.EmpService;
import com.ambow.springboot.service.UserService;

import com.ambow.springboot.util.MailUtil;
import com.ambow.springboot.util.SendMessage;
import org.apache.commons.httpclient.HttpException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;


import javax.servlet.http.HttpServletRequest;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Component
@RunWith(SpringRunner.class)
@SpringBootTest
public class yyTest {
    @Autowired
    private BuyService buyService;
    @Autowired
    private BuyMapper buyMapper;
    @Autowired
    private UserService userService;

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private EmpService empservice;

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
        buy.setName("yrrdf");
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
     *后台员工测试
     * */
    @Test
    public void testEmpLogin() {
        Emp emp = new Emp();
        emp.setUsername("22222");
        emp.setPassword("12345");
        if (empservice.login(emp) != null) {
            System.out.println("登录成功");
        }else{

            System.out.println("false");
        }
    }
    /*
     * 用户注册测试
     * */
    @Test
    public void testZhuce() {
        User user = new User();
        user.setPassword("221");
        user.setName("11");
        user.setPhone("31");
        user.setIntegral(100);
        userService.insert(user);
    }
    /*
     * 用户登录短信验证测试
     * */
    @Test
    public void sendmelogin () throws HttpException, IOException {
        HttpServletRequest request = null;
        String phone = "15848639533";
        HashMap<String, String> m = SendMessage.getMessageStatus(phone);

    }
    /*
     * 用户注册短信验证测试
     * */
    @Test
    public void sendme() throws HttpException, IOException {
        HttpServletRequest request = null;
        String phone = "15848639533";
        HashMap<String, String> m = SendMessage.getMessageStatus(phone);

    }

    @Test
    public  void sendEmail() {

        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIulon7QIT4EGk",
                "KtzINaHjOCONW9mSypm5Yh8A9ro7E4");
        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        // try {
        // DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com",
        // "ap-southeast-1", "Dm", "dm.ap-southeast-1.aliyuncs.com");
        // } catch (ClientException e) {
        // e.printStackTrace();
        // }
        IAcsClient client = new DefaultAcsClient(profile);

        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            // request.setVersion("2017-06-22");//
            // 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("xiaozu@innerstudent.group");
            request.setFromAlias("雷园");
            request.setAddressType(1);
            request.setTagName("AboutUserName");
            request.setReplyToAddress(true);
            request.setToAddress("15848639533@163.com");
            request.setSubject("今日订餐订单");
            request.setHtmlBody("MailTemplate.html" );
            client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
    /*订单根据day模糊查询*/
    @Test
    public  void  testOrder(){

        Orders order=new Orders();

        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
            String nowdates=sdfs.format(c.getTime());
            System.out.println(ordersMapper.likeListOrders(nowdates));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     /*定时测试
     * */ @Scheduled(cron = " */5 * * * * ?")
     @Test
    public void   testtime(){
        System.out.println("定时测试++++++++++++");
    }
    /*
    * 邮箱附件测试
    * */
    @Test
    public void  testfujian(){

        new MailUtil().send("15848639533@163.com", "在线点餐今日订单", "今日订单","C:/AppData/test.xlsx");
    }


    }
