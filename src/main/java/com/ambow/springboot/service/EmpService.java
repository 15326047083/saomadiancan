package com.ambow.springboot.service;
import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.entity.Goods;

import java.util.List;


public interface EmpService {
    /**
     * 查看所有员工信息
     */
     List<Emp> toList();
    /*
     * 根据商品名查询
     * */
    Emp selectByName(String username);
    /*
    /**
     * 增加员工信息
     */
    void toSave(Emp emp);
    /**
     * 根据id删除员工信息
     */
    int delete(Integer id);
    /**
     * 修改员工信息
     */
     void toUpdate(Emp emp);
    /**
     * 根据id查看员工信息
     */
     Emp getList(Integer id);
    /**
     * roles查询是采购员的
     */
    List<Emp> toroleList();
    /*
    * 员工登录
    * */
    Emp login(Emp emp);
    /*
    * 根据员工id和密码查询
    * */
    Emp selectByPassword(Integer empid,String password);
}
