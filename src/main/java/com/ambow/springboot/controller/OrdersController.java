package com.ambow.springboot.controller;

import com.ambow.springboot.WebSocket;
import com.ambow.springboot.entity.Orders;
import com.ambow.springboot.entity.Purchase;
import com.ambow.springboot.entity.User;
import com.ambow.springboot.service.OrdersService;
import com.ambow.springboot.service.PurchaseService;
import com.ambow.springboot.util.Page;
import com.ambow.springboot.vo.CartVo;
import com.ambow.springboot.vo.PurchaseGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrdersController {

    @Autowired
    private WebSocket webSocket;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private PurchaseService purchaseService;

    private Orders orders;
    private Purchase purchase;
    private List<Purchase> purchaseList;
    private List<Orders> ordersList;
    private List<PurchaseGoodsVo> purchaseGoodsVoList;

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

    /*
     * 前台生成订单,同时生成中间表
     * */
    @RequestMapping("/toSave")
    @ResponseBody
    public String toSave(HttpServletResponse response, HttpServletRequest request) throws
            UnsupportedEncodingException {
        //获取session中的id和桌号和人数
        HttpSession session = request.getSession();
        Integer people_num = 2; //(Integer) session.getAttribute("people_num");
        Integer desk_num = 1; //(Integer) session.getAttribute("desk_num");
        User user = (User) session.getAttribute("user");
        Integer user_id = null;
        if (user != null) {
            user_id = user.getId();
        }

        //自动生成单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");   //时间格式
        String time = sdf.format(new Date());   //取当前时间
        int radom = (int) ((Math.random() * 9 + 1) * 100000);
        String aa = String.valueOf(radom);
        String number = aa + time;
        long order_number = Long.parseLong(number);//生成订单号

        //将订单号放在cookie中
        Cookie order_numberCookie = new Cookie("order_numberCookie", number);
        order_numberCookie.setMaxAge(24 * 60 * 60);   //存活期为一天 24*60*60
        order_numberCookie.setPath("/");
        response.addCookie(order_numberCookie);

        //获取购物车的内

        //中间表操作
        Purchase purchase = new Purchase();
        List<CartVo> listCart = getCartInCookie(response, request);
        int sumPrice = 0;
        for (CartVo cart : listCart) {
            sumPrice = sumPrice + cart.getNum() * cart.getGoodsDiscount();//计算总价
            int goods_id = cart.getGoodsId();
            int num = cart.getNum();

            //中间表赋值
            purchase.setGoodsId(goods_id);
            purchase.setNum(num);
            purchase.setOrderNum(order_number);
            purchaseService.toSave(purchase);
        }
        Orders orders = new Orders();
        orders.setAllPrice(sumPrice);
        orders.setDeskNum(desk_num);
        orders.setOrderNum(order_number);
        orders.setGenerateTime(new Date());
        orders.setPeopleNum(people_num);
        orders.setState(0);
        if (user != null) {
            orders.setUserId(user_id);
        }
        //生成订单
        ordersService.toSave(orders);
//        Cookie cookie = getCookie(request);
//        if (cookie != null) {
//            // 设置寿命为0秒
//            cookie.setMaxAge(0);
//            // 设置路径
//            cookie.setPath("/");
//            // 设置cookie的value为null
//            cookie.setValue(null);
//            // 更新cookie
//            response.addCookie(cookie);
//        }

        webSocket.sendMessage("有新的订单");

        return "success";
    }

    /**
     * 获取名为"order_numberCookie"的cookie
     *
     * @param request
     * @return cookie
     */
    public String getorder_numberCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String order_numberCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("order_numberCookie".equals(cookie.getName())) { //获取cookie中的订单号
                    order_numberCookie = cookie.getValue();
                }
            }
        }
        return order_numberCookie;
    }

    /*
     * 前台根据cookie中的订单号查询中间表的内容
     * */
    @RequestMapping("/toListPurchaseByOrderNum")
    @ResponseBody
    public List<PurchaseGoodsVo> toListPurchaseByOrderNum(HttpServletRequest request) {

        //获取cookie中的订单号
        String order_numberCookie = getorder_numberCookie(request);
        long order_number = Long.parseLong(order_numberCookie);
        //前台根据cookie中的订单号查询中间表的内容
        if (order_number > 0) {
            purchaseGoodsVoList = purchaseService.toListPurchaseByOrderNumber(order_number);
            return purchaseGoodsVoList;
        } else {
            return null;
        }
    }


    /*
     * 前台根据cookie中的订单号查询订单的内容
     * */
    @RequestMapping("/toListOrdersByOrderNum")
    @ResponseBody
    public Orders toListOrdersByOrderNum(HttpServletRequest request) {
        //获取cookie中的订单号
        String order_numberCookie = getorder_numberCookie(request);
        long order_number = Long.parseLong(order_numberCookie);
        if (order_number > 0) {
            orders = ordersService.toListOrdersByOrderNum(order_number);
            return orders;
        } else {
            return null;
        }
    }


    /*
     * 后台根据订单号查询订单中间表的所有内容
     * */
    @RequestMapping("/toListPurchase/{order_num}")
    @ResponseBody
    public List<PurchaseGoodsVo> toListPurchase(@PathVariable("order_num") Long order_num) {

        purchaseGoodsVoList = purchaseService.toListPurchaseByOrderNumber(order_num);
        return purchaseGoodsVoList;
    }

    /*
     * 后台查询所有订单内容,分页
     * */
    @RequestMapping("/toListOrders")
    @ResponseBody
    public Page<Orders> toListOrders(Integer state, @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "8") Integer rows) {

        Page<Orders> ordersList = ordersService.toListOrders(page, rows, state);
        return ordersList;
    }

    /*
     * 网上订单付款，修改状态为1
     * */
    @RequestMapping("/toUpdateUp")
    public String toUpdateUp(Long orders_num) {
        ordersService.toUpdateUp(orders_num);
        return "success";
    }

    /*
     * 线下订单付款，修改状态为2
     * */
    @RequestMapping("/toUpdateDown")
    public String toUpdateDown(Long orders_num) {
        ordersService.toUpdateDown(orders_num);
        return "success";
    }

    /*
     * 删去订单中（中间表）的一条数据
     * */
    @RequestMapping("toDeletePurchase/{id}")

    public String toDeletePurchase(@PathVariable("id") Integer id) {
        purchaseService.toDeletePurchase(id);
        return "success";
    }

}
