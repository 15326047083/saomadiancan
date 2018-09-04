package com.ambow.springboot;

import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.mapper.EmpMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpTest {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void toSave() {
        Emp emp = new Emp();

        emp.setName("赵六");
        emp.setUsername("王老吉");
        emp.setPassword("123");
        emp.setRoles("扫地的");
        emp.setEntryTime(new Date());
        emp.setLeaveTime(null);
        emp.setWage(1000);
        emp.setTicheng(0);
        empMapper.insertSelective(emp);

    }

    /**
     * 查所有
     */
        @Test
    public  void getAll(){
            System.out.println(empMapper.getAll());
        }
    /**
     * 根据id查
     */

    @Test
    public  void getOne(){
        System.out.println(empMapper.selectByPrimaryKey(1));
    }
    /**
     * 根据id删除
     */
    @Test
    public  void delete(){
        System.out.println(empMapper.deleteByPrimaryKey(2));
    }
    /**
     * 修改
     */
    @Test
    public void toUpdate(){

        Emp emp =new Emp();
        emp.setId(1);
        emp.setUsername("2222");
        empMapper.updateByPrimaryKeySelective(emp);
    }
    /**
     * roles查询是采购员的
     */
    @Test
    public void selectRole(){

        System.out.println(empMapper.selectByRoles());
    }
    }

