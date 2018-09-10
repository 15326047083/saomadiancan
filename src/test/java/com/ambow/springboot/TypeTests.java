package com.ambow.springboot;

import com.ambow.springboot.entity.Type;
import com.ambow.springboot.mapper.TypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeTests {
    @Autowired
    private TypeMapper typMapper;
    /*
    * 添加测试
    * */
    @Test
    public void testTypeAdd() {
        Type type=new Type();
        type.setName("酒水");
        type.setNum(20);
        typMapper.insert(type);
    }
    /*
    * 修改测试
    * */
    @Test
    public void testUpdate(){
        Type type=new Type();
        type.setId(1);
        type.setName("烟");
        type.setNum(1);
        typMapper.updateByPrimaryKeySelective(type);
    }

    /*
    * 批量删除测试
    * */
    @Test
    public void testdetele(){
        Type type=new Type();
        Integer[] ids={1,2};
        typMapper.deleteByPrimaryKey(ids);
    }

    /*
     * 批量查询测试
     * */
    @Test
    public void testSelecrList(){
        Type type=new Type();
        Integer[] ids={1,2};
        System.out.println(typMapper.selectGoodsByTypeId(ids));
    }
    /*
     * 查找所有类型测试
     * */
    @Test
    public void testSelectAllType(){
        Type type=new Type();

        System.out.println(typMapper.toList());
    }

    /*
     * 根据id查找要修改的信息
     * */
    @Test
    public void testSelectById(){
        Type type=new Type();
        int id=1;
        System.out.println(typMapper.selectByPrimaryKey(id));
    }
    /*
     * 根据名字查找信息
     * */
    @Test
    public void testSelectByName(){
        Type type=new Type();
        String name="1";
        typMapper.selectByName(name);
    }
}
