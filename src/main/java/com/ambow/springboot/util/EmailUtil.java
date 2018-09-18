package com.ambow.springboot.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;

import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import com.ambow.springboot.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMultipart;





/**
 * 发送E-mail验证码 点餐定时（24H）订单发送
 *
 * @author HP5
 *
 */
@Component
public class EmailUtil {
    @Autowired
    private OrdersService ordersService;



    @Scheduled(cron = "0  00 22  * * ?")/* 秒、分、时、日、月、年*/
    public void sendEmail() {
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
        String info=ReadHTML.reMailString();
        IAcsClient client = new DefaultAcsClient(profile);


        SingleSendMailRequest request = new SingleSendMailRequest();
        // MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        //创建一个包含HTML内容的MimeBodyPart
        BodyPart body=new MimeBodyPart();
        //设置html内容

        try {
            body.setContent(info,"text/html;charset=utf-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //将MimeMultipart设置为邮件内容
        try {
            mainPart.addBodyPart(body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
           /* BodyPart attachPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(attachPath);
            attachPart.setDataHandler(new DataHandler(fileDataSource));
            attachPart.setFileName(MimeUtility.encodeText(fileDataSource.getName()));
            multipart.addBodyPart(attachPart);

            mm.setContent(multipart);
            Transport.send(mm);*/
            // request.setVersion("2017-06-22");//
            // 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("xiaozu@innerstudent.group");
            request.setFromAlias("雷园");
            request.setAddressType(1);
            request.setTagName("AboutUserName");
            request.setReplyToAddress(true);
            request.setToAddress("15848639533@163.com");
            request.setSubject("今日订餐订单");
            request.setHtmlBody("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "\n" +
                    "<table style=\"border-bottom: #006699 1px solid; border-left: #006699 1px solid; font-size: 12px;\n" +
                    "\n" +
                    "            border-top: #006699 1px solid; border-right: #006699 1px solid\" border=\"0\" cellspacing=\"0\"\n" +
                    "\n" +
                    "       cellpadding=\"2\" width=\"80%\">\n" +
                    "\n" +
                    "    <tbody>\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "        <td>\n" +
                    "\n" +
                    "            订单号： <%=Order.OrderNo%>\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "        <td>\n" +
                    "\n" +
                    "            客户编号："+"kujyuyui"+"\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "        <td>\n" +
                    "\n" +
                    "            下单日期:<%=Order.CreateDate%>\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "    </tr>\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "        <td>\n" +
                    "\n" +
                    "            运费：<%=Order.Freight%>\n" +
                    "\n" +
                    "        <td>\n" +
                    "\n" +
                    "            交易币种：<%=Order.Currency%>\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "        <td>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "    </tr>\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "        <td colspan=\"3\">\n" +
                    "\n" +
                    "            &nbsp;\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "    </tr>\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "        <td colspan=\"3\">\n" +
                    "\n" +
                    "            送货地址：<%=Order.ShipAddress%>\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "    </tr>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "        <td  colspan=\"3\">\n" +
                    "\n" +
                    "            <font  color=\"red\">具体的交货时将将由我们的客服人员与您联系协商 </font>\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "    </tr>\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    <tr>\n" +
                    "\n" +
                    "        <td colspan=\"3\">\n" +
                    "\n" +
                    "            <br>\n" +
                    "\n" +
                    "            <table style=\"font-size: 12px\" border=\"0\" cellspacing=\"5\" cellpadding=\"4\" width=\"100%\"\n" +
                    "\n" +
                    "                   align=\"center\">\n" +
                    "\n" +
                    "                <tbody>\n" +
                    "\n" +
                    "                <tr>\n" +
                    "\n" +
                    "                    <td>\n" +
                    "\n" +
                    "                        <strong>产品编号</strong>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                    <td>\n" +
                    "\n" +
                    "                        <strong>单位</strong>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                    <td width=\"60\">\n" +
                    "\n" +
                    "                        <strong>数量</strong>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                    <td width=\"80\">\n" +
                    "\n" +
                    "                        <strong>单价</strong>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                </tr>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                <%  foreach (SendMailTemplate.OrderItem item in Order.OrderItems)\n" +
                    "\n" +
                    "                { %>\n" +
                    "\n" +
                    "                <tr>\n" +
                    "\n" +
                    "                    <td>\n" +
                    "\n" +
                    "                        <%=item.ItemCode%>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                    <td>\n" +
                    "\n" +
                    "                        <%=item.Unit%>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                    <td>\n" +
                    "\n" +
                    "                        <%=item.Quantity%>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "                    <td>\n" +
                    "\n" +
                    "                        <%=item.BasicPrice%>\n" +
                    "\n" +
                    "                    </td>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                </tr>\n" +
                    "\n" +
                    "                <%} %>\n" +
                    "\n" +
                    "                </tbody>\n" +
                    "\n" +
                    "            </table>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        </td>\n" +
                    "\n" +
                    "    </tr>\n" +
                    "\n" +
                    "    </tbody>\n" +
                    "\n" +
                    "</table>\n" +
                    "</html>");
            client.getAcsResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}