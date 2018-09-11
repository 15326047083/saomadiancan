package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Buy;
import com.ambow.springboot.entity.User;
import com.ambow.springboot.mapper.UserMapper;
import com.ambow.springboot.service.UserService;
import com.ambow.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/*
* 用户登陆注册serviceIMpl
* @Auther yy
* */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;
    /*
    * 用户登录
    * */
    @Override
    public User login(User user) {
       User users=usermapper.login(user);
        return users;
    }

    /*
    * 查找手机号是否被注册过
    * */
    public boolean listphone(User user) {
        boolean flag = false;
        User phonenumber = usermapper.listphone(user);
        if (phonenumber != null) {
            flag = true;
        }
        return flag;

    }
    @Override
    public Page<User> lsituser(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "4")Integer rows) {
        User user = new User();
        List<User> lsit=usermapper.listUser();
        user.setstart((page - 1) * rows);
        user.setrows(rows);
        Page<User> pages = new Page<User>();
        pages.setPage(page);
        pages.setRows(lsit);
        pages.setSize(rows);
        pages.setTotal(lsit.size());
        return pages;

    }

    /*
    *  用户注册
    * */
    public void insert(User user) {
        usermapper.insert(user);
    }
}
