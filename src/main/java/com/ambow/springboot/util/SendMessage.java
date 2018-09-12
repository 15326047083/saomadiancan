package com.ambow.springboot.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;




public class SendMessage {
	public static HashMap<String, String> getMessageStatus(String phone)
			throws HttpException, IOException {
		HashMap<String, String> m = new HashMap<String, String>();
		// http协议
		HttpClient client = new HttpClient();
		// 连接第三方平台
		PostMethod post = new PostMethod("http://gbk.api.smschinese.cn/");//gbk编码访问
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转

		// 生成六位验证
		String charValue = "";
		for (int i = 0; i < 6; i++) {
			char c = (char) (randomInt(0, 9) + '0');
			charValue += String.valueOf(c);
		}
		// 短信模板
		NameValuePair[] data = { new NameValuePair("Uid", "背影yy"), // sms短信
																	// 注册的用户名
				new NameValuePair("Key", "d41d8cd98f00b204e980"), // 密匙
				new NameValuePair("smsMob", phone),// 要发送的手机号
				new NameValuePair("smsText", "在线点餐验证码:" + charValue + "验证码有效时间为三分钟") // 短信内容
		};
		post.setRequestBody(data);
		client.executeMethod(post);
		// 获取http
		Header[] headers = (Header[]) post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		// 获取返回消息
		String result = new String(post.getResponseBodyAsString().getBytes(
				"gbk"));
		System.out.println(result); // 打印返回消息
		// 将返回消息和6位数验证码放入到m列表里面
		m.put("result", result);
		m.put("code", charValue);
		// 断开与第三方平台的连接
		post.releaseConnection();
		return m;

	}
	// 生成验证码
	public static int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
	}

}

