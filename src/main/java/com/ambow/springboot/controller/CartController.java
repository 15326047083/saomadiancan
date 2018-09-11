package com.ambow.springboot.controller;

import com.ambow.springboot.WebSocket;
import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.service.GoodsService;
import com.ambow.springboot.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * cookie购物车
 */

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/getNumByGoodsId/{goodsId}")
    public int getNumByGoodsId(@PathVariable("goodsId") Integer goodsId, HttpServletResponse response,
                               HttpServletRequest request) throws
            UnsupportedEncodingException {
        int num = 0;
        // 获取cookie中购物车列表
        List<CartVo> cartVos = getCartInCookie(response, request);
        for (CartVo c : cartVos) {
            if (c.getGoodsId() == goodsId) {
                num = c.getNum();
                break;
            }
        }
        return num;
    }

    /**
     * 根据ID删除删除购物车内的商品
     *
     * @param goodsId  商品ID
     * @param request
     * @param response
     * @return 成功与否
     * @throws UnsupportedEncodingException 抛出异常
     */
    @RequestMapping("/deleteByGoodsId/{goodsId}")
    public String deleteByGoodsId(@PathVariable("goodsId") Integer goodsId, HttpServletRequest request,
                                  HttpServletResponse response) throws UnsupportedEncodingException {
        // 获取cookie中购物车列表
        List<CartVo> cartVos = getCartInCookie(response, request);
        CartVo deleteCart = null;
        // 判断购物车列表是否为空
        if (cartVos.size() > 0) {
            // 循环购物车列表寻找相同ID的商品
            for (CartVo c : cartVos) {
                if (c.getGoodsId().equals(goodsId)) {
                    deleteCart = c;
                    break;
                }
            }
            // 判断是否找到相同ID的商品
            if (deleteCart != null) {
                // 判断购物车中商品的数量
                if (deleteCart.getNum() > 1) {
                    // 数量大于1增让数量-1
                    deleteCart.setNum(deleteCart.getNum() - 1);
                    cartVos.remove(deleteCart);
                    cartVos.add(deleteCart);
                } else {
                    // 否则直接删除该商品在购物车中的信息
                    cartVos.remove(deleteCart);
                }
                // 获取名为"cart"的cookie
                Cookie cookie = getCookie(request);
                // 为cookie设置value
                cookie.setValue(URLEncoder.encode(makeCookieValue(cartVos), "utf-8"));
                // 设置寿命
                cookie.setMaxAge(60 * 10);
                // 设置路径
                cookie.setPath("/");
                // 更新cookie
                response.addCookie(cookie);
            }
        }
        return "success";
    }

    /**
     * 清空购物车
     *
     * @param response
     * @param request
     * @return 成功与否
     */
    @RequestMapping("/deleteAllCookie")
    public String deleteCookie(HttpServletResponse response, HttpServletRequest request) {
        // 获取名为"cart"的cookie
        Cookie cookie = getCookie(request);
        if (cookie != null) {
            // 设置寿命为0秒
            cookie.setMaxAge(0);
            // 设置路径
            cookie.setPath("/");
            // 设置cookie的value为null
            cookie.setValue(null);
            // 更新cookie
            response.addCookie(cookie);
        }
        return "success";
    }

    /**
     * 获取购物车列表
     *
     * @param request
     * @param response
     * @return 购物车列表
     * @throws UnsupportedEncodingException 抛出异常
     */
    @RequestMapping("/getCart")
    public List<CartVo> getCart(HttpServletRequest request, HttpServletResponse response) throws
            UnsupportedEncodingException {
        return getCartInCookie(response, request);
    }

    /**
     * 添加商品至购物车列表
     *
     * @param goodsId  商品ID
     * @param request
     * @param response
     * @throws UnsupportedEncodingException 异常抛出
     */
    @RequestMapping("/addGoodsToCart/{goodsId}")
    public void addGoodsToCart(@PathVariable("goodsId") Integer goodsId, HttpServletRequest request,
                               HttpServletResponse response) throws UnsupportedEncodingException {

        webSocket.sendMessage("4");


        // 从cookie中获取购物车列表
        List<CartVo> cartVos = getCartInCookie(response, request);
        Cookie cookie_2st;
        // 如果购物车列表为空
        if (cartVos.size() <= 0) {
            CartVo cartVo = new CartVo(); // 测试用，实际应当根据id获取
            cartVo.setNum(1);
            cartVo.setGoodsId(goodsId);
            Goods goods = goodsService.getById(goodsId);
            cartVo.setGoodsNum(goods.getNum());
            cartVo.setGoodsTypeId(Integer.parseInt(goods.getTypeId()));
            cartVo.setGoodsPrice(goods.getPrice());
            cartVo.setGoodsDiscount(goods.getDiscount());
            cartVo.setGoodsName(goods.getName());
            // 将当前传来的商品添加到购物车列表
            cartVos.add(cartVo);
            if (getCookie(request) == null) {
                // 制作购物车cookie数据
                cookie_2st = new Cookie("cart", URLEncoder.encode(makeCookieValue(cartVos), "utf-8"));
                cookie_2st.setPath("/");//设置在该项目下都可以访问该cookie
                cookie_2st.setMaxAge(60 * 30);//设置cookie有效时间为30分钟
                response.addCookie(cookie_2st);//添加cookie
            } else {
                cookie_2st = getCookie(request);
                cookie_2st.setPath("/");//设置在该项目下都可以访问该cookie
                cookie_2st.setMaxAge(60 * 30);//设置cookie有效时间为30分钟
                cookie_2st.setValue(URLEncoder.encode(makeCookieValue(cartVos)));
                response.addCookie(cookie_2st);//添加cookie
            }
        }
        // 当获取的购物车列表不为空时
        else {
            int bj = 0;
            for (CartVo cart : cartVos) {
                // 如果购物车中存在该商品则数量+1
                if (cart.getGoodsId() == goodsId) {
                    cart.setNum(cart.getNum() + 1);
                    bj = 1;
                    break;
                }
            }
            if (bj == 0) {
                CartVo cartVo = new CartVo(); // 测试用，实际应当根据id获取
                cartVo.setNum(1);
                cartVo.setGoodsId(goodsId);
                Goods goods = goodsService.getById(goodsId);
                cartVo.setGoodsNum(goods.getNum());
                cartVo.setGoodsTypeId(Integer.parseInt(goods.getTypeId()));
                cartVo.setGoodsPrice(goods.getPrice());
                cartVo.setGoodsDiscount(goods.getDiscount());
                cartVo.setGoodsName(goods.getName());
                // 将当前传来的商品添加到购物车列表
                cartVos.add(cartVo);
            }
            // 获取名为"cart"的cookie
            cookie_2st = getCookie(request);
            cookie_2st.setPath("/");//设置在该项目下都可以访问该cookie
            cookie_2st.setMaxAge(60 * 30);//设置cookie有效时间为30分钟
            cookie_2st.setValue(URLEncoder.encode(makeCookieValue(cartVos))); // 设置value
            response.addCookie(cookie_2st);//添加cookie
        }
    }

    /**
     * 制作cookie所需value
     *
     * @param cartVos 购物车列表
     * @return 解析为字符串的购物车列表，属性间使用"="相隔，对象间使用"=="相隔
     */
    public String makeCookieValue(List<CartVo> cartVos) {
        StringBuffer buffer_2st = new StringBuffer();
        for (CartVo item : cartVos) {
            buffer_2st.append(item.getGoodsId() + "=" + item.getGoodsTypeId() + "=" + item.getGoodsName() + "="
                    + item.getGoodsPrice() + "=" + item.getGoodsDiscount() + "=" + item.getGoodsNum() + "=" + item
                    .getGoodsInfo() + "=" + item.getNum() + "==");
        }
        if (buffer_2st.toString().length() > 2)
            return buffer_2st.toString().substring(0, buffer_2st.toString().length() - 2);
        else
            return buffer_2st.toString();
    }

    /**
     * 获取名为"cart"的cookie
     *
     * @param request
     * @return cookie
     */
    public Cookie getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie cart_cookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cart".equals(cookie.getName())) { //获取购物车cookie
                    cart_cookie = cookie;
                }
            }
        }
        return cart_cookie;
    }

    /**
     * 获取cookie中的购物车列表
     *
     * @param response
     * @param request
     * @return 购物车列表
     * @throws UnsupportedEncodingException 抛出异常
     */
    public List<CartVo> getCartInCookie(HttpServletResponse response, HttpServletRequest request) throws
            UnsupportedEncodingException {
        // 定义空的购物车列表
        List<CartVo> items = new ArrayList<CartVo>();
        String value_1st = "";
        // 购物cookie
        Cookie cart_cookie = getCookie(request);
        // 判断cookie是否为空
        if (cart_cookie != null) {
            // 获取cookie中String类型的value
            value_1st = URLDecoder.decode(cart_cookie.getValue(), "utf-8");//从cookie获取购物车
            // 判断value是否为空或者""字符串
            if (value_1st != null && !"".equals(value_1st)) {
                // 解析字符串中的数据为对象并封装至list中返回给上一级
                String[] arr_1st = value_1st.split("==");
                for (String value_2st : arr_1st) {
                    String[] arr_2st = value_2st.split("=");
                    CartVo item = new CartVo();
                    item.setGoodsId(Integer.parseInt(arr_2st[0])); //商品id
                    item.setGoodsTypeId(Integer.parseInt(arr_2st[1])); //商品类型ID
                    item.setGoodsName(arr_2st[2]); //商品名
                    item.setGoodsPrice(Integer.parseInt(arr_2st[3])); //商品市场价格
                    item.setGoodsDiscount(Integer.parseInt(arr_2st[4]));//商品折后价格
                    item.setGoodsNum(Integer.parseInt(arr_2st[5]));//商品月销量
                    item.setGoodsInfo(arr_2st[6]);//商品详情
                    item.setNum(Integer.parseInt(arr_2st[7]));//加入购物车数量
                    items.add(item);
                }
            }
        }
        return items;

    }
}
