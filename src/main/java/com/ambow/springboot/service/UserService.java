package com.ambow.springboot.service;

import com.ambow.springboot.entity.User;
import com.ambow.springboot.util.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
*用户登录
* */
public interface UserService {
    /*
    * 登录方法
    * */
    User login(User user);
    /*
    * 注册方法
    * */
    void insert(User user);
    /*
    *  查找手机号是否被注册过
    * */
    boolean  listphone(User user);
    /*
    * 查询所有
    * */
    Page<User> lsituser(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "4")Integer rows);
}
