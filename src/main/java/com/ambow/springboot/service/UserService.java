package com.ambow.springboot.service;

import com.ambow.springboot.entity.User;
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
}
