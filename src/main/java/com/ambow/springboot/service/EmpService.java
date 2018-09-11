package com.ambow.springboot.service;
import com.ambow.springboot.entity.Emp;
import java.util.List;


public interface EmpService {
    /**
     * 查看所有员工信息
     */
     List<Emp> toList();
    /**
     * 增加员工信息
     */
    int toSave(Emp emp);
    /**
     * 根据id删除员工信息
     */
    int delete(Integer id);
    /**
     * 修改员工信息
     */
     int toUpdate(Emp emp);
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
}
