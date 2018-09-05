package com.ambow.springboot.service.impl;

import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.mapper.EmpMapper;
import com.ambow.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 查看所有员工信息
     */
    @Override
    public List<Emp> toList() {
        List<Emp> emps = empMapper.getAll();
        return emps;
    }

    /**
     * 增加员工信息
     */
    @Override
    public int toSave(Emp emp) {
        emp.setEntryTime(new Date());
        emp.setPassword("123456");
        return empMapper.insertSelective(emp);
    }

    /**
     * 根据id删除员工
     */
    @Override
    public int delete(Integer id) {
        return empMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改员工信息
     */
    @Override
    public int toUpdate(Emp emp) {
        return empMapper.updateByPrimaryKeySelective(emp);
    }

    /**
     * 根据id查看员工信息
     */
    @Override
    public Emp getList(Integer id) {
        return empMapper.selectByPrimaryKey(id);
    }

    /**
     * roles查询是采购员的
     *
     * @return
     */
    @Override
    public List<Emp> toroleList() {
        List<Emp> emps = empMapper.selectByRoles();
        return emps;
    }
}