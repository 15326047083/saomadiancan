package com.ambow.springboot;

import com.ambow.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMysql() {
        System.out.println(userMapper.selectByPrimaryKey(1));
    }

}
