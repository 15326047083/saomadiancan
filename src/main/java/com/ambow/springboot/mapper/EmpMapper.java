package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.entity.Goods;
import com.ambow.springboot.entity.Roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpMapper {
    /**
     * 根据id删除某个用户信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Emp record);
    /**
     * 得到所有的用户信息
     * @return List<Emp>
     */
    List<Emp> getAll();
    /**
     * 根据id查找某个员工信息
     * @param id
     * @return Emp
     */
    Emp selectByPrimaryKey(Integer id);
    /**
     * 根据id更新一条员工信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     *roles查询是采购员的
     * @param
     * @return
     */
    List<Emp> selectByRoles();
    /*
     * 后台emp登录方法
     * */
    Emp login(Emp emp);
    /*
    * 根据个人密码和员工Empid查询
    * */
    Emp selectBypassword(@Param("empid") Integer empid,@Param("passowrd") String password);
    int updateByPrimaryKey(Emp record);
    int insert(Emp record);
    Emp selectByName(String username);
}