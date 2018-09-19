package com.ambow.springboot.controller;

import com.ambow.springboot.WebSocket;
import com.ambow.springboot.entity.Emp;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 跳转
 */
@Controller
@RequestMapping("/empJump")
public class EmpJumpController {
    @Autowired
    private WebSocket webSocket;
    @Autowired
    private ResourceLoader resourceLoader;

    // 新增员工
    @RequestMapping("/toEmpNew")
    public String toEmpNew() {
        return "manager/emp/add";
    }

    // 员工列表
    @RequestMapping("/toEmpList")
    public String toEmpList() {
        return "manager/emp/list";
    }

    // 修改员工
    @RequestMapping("/toEmpUpdate/{empId}")
    public String toEmpUpdate(@PathVariable("empId") Integer empId, Model model) {
        model.addAttribute("empId", empId);
        return "manager/emp/update";
    }

    // 采购列表
    @RequestMapping("/toBuyList")
    public String toBuyList() {
        return "manager/buy/list";
    }

    // 新增采购记录
    @RequestMapping("/toBuyNew")
    public String toBuyNew() {
        return "manager/buy/add";
    }

    // 评价回复列表
    @RequestMapping("/toDiscussList")
    public String toDiscussList() {
        return "manager/discuss/discuss";
    }

    // 购物车
    @RequestMapping("/toCart")
    public String toCart() {
        return "phone/cart";
    }

    // 商品列表，点餐
    @RequestMapping("/toGoodsList")
    public String toGoodsList() {
        return "phone/goods";
    }

    /**
     * 扫码进入用餐人数选择
     *
     * @param deskNum 桌号
     * @param request 请求
     * @return 页面
     */
    @RequestMapping("/toPeopleNum/{deskNum}")
    public String toPeopleNum(@PathVariable("deskNum") Integer deskNum, HttpServletRequest request) {
        request.getSession().setAttribute("deskNum", deskNum);
        return "phone/peopleNum";
    }

    /**
     * 确定用餐人数并跳转至点餐页面
     *
     * @param peopleNum 用餐人数
     * @param request   请求
     * @return 点餐页面
     */
    @RequestMapping(value = "/surePeopleNum", method = RequestMethod.POST)
    public String surePeopleNum(@RequestParam("peopleNum") Integer peopleNum, HttpServletRequest request) {
        request.getSession().setAttribute("peopleNum", peopleNum);
        return "phone/goods";
    }

    // 订单页
    @RequestMapping("/toOrder")
    public String toOrder() {
        return "phone/order";
    }

    // 支付页面
    @RequestMapping("/toPay")
    public String toPay() {
        return "phone/pay";
    }


    // 查看员工自己信息
    @RequestMapping("/toEmpBy")
    public String toEmpby(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Emp emps = (Emp) session.getAttribute("emp");
        Integer empId = emps.getId();
        model.addAttribute("empId", empId);
        return "manager/emp/myInfo";
    }

    // 员工修改密码
    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Emp emp = (Emp) session.getAttribute("emp");
        model.addAttribute("emp", emp);
        return "manager/emp/updatePassword";
    }

    // 获取用户列表
    @RequestMapping("/toUserList")
    public String toUserList() {
        return "phone/user/userList";
    }

    // 用户登陆
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "phone/user/login";
    }

    // 用户注册
    @RequestMapping("/toUserRegister")
    public String toUserRegister() {
        return "phone/user/register";
    }

    // 我的详情
    @RequestMapping("/toMy")
    public String toMy() {
        return "phone/user/my";
    }

    // 我的订单
    @RequestMapping("/toMyOrders")
    public String toMyOrders() {
        return "phone/user/myOrder";
    }

    // 我的积分
    @RequestMapping("/toMyIntegral")
    public String toMyIntegral() {
        return "phone/user/integral";
    }

    // 呼叫服务员
    @RequestMapping("/help")
    @ResponseBody
    public String help(HttpServletRequest request) {
        String deskNum = (Integer) request.getSession().getAttribute("deskNum") + "";
        webSocket.sendMessage(deskNum);
        return "success";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().setAttribute("emp", null);
        return "redirect:/jump/toEmpLogin";
    }

    // 去评价
    @RequestMapping("/toDiscuss")
    public String toDiscuss() {
        return "phone/discuss";
    }

    /**
     * 富文本图片上传
     *
     * @param request request
     * @param file    图片文件
     * @return 返回
     * {
     * "code": 0 //0表示成功，其它失败
     * ,"msg": "" //提示信息 //一般上传失败后返回
     * ,"data": {
     * "src": "图片路径"
     * ,"title": "图片名称" //可选
     * }
     * }
     * @throws IOException 抛出异常
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, @RequestParam("goodsId")
            Integer goodsId) throws IOException {
        //服务器上使用
        String rootPath = request.getSession().getServletContext().getRealPath("/resource/uploads/");//target的目录
        //原始名称
        String originalFilename = file.getOriginalFilename();
        //新的文件名称
        String newFileName = goodsId + originalFilename.substring(originalFilename.lastIndexOf("."));

        File newFile = new File(rootPath + newFileName);
        //判断目标文件所在的目录是否存在
        if (!newFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        //将内存中的数据写入磁盘
        file.transferTo(newFile);
        //完整的url
        String fileUrl = "/resource/uploads/" + newFileName;
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map.put("code", 0);//0表示成功，1失败
        map.put("msg", "上传成功");//提示消息
        map.put("data", map2);
        map2.put("src", fileUrl);//图片url
        map2.put("title", newFileName);//图片名称，这个会显示在输入框里
        String result = new JSONObject(map).toString();
        return "redirect:/goodsJump/toGoodsList";
    }

    /**
     * 图片展示方法
     *
     * @param fileName 文件名
     * @param request  请求
     * @return 文件
     */
    @RequestMapping("/imgShow/{fileName}")
    public ResponseEntity showPhotos(@PathVariable("fileName") String fileName, HttpServletRequest request) {
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            String rootPath = request.getSession().getServletContext().getRealPath("/resource/uploads/");//target的目录
            return ResponseEntity.ok(resourceLoader.getResource("file:" + rootPath + fileName + ".jpeg"));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
