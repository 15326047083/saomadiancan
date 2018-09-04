package com.ambow.springboot.mapper;

import com.ambow.springboot.entity.Emp;
import com.ambow.springboot.entity.Roles;
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
     * 插入一条员工信息
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
    int updateByPrimaryKey(Emp record);
    int insert(Emp record);
}