package com.ambow.springboot;

import com.ambow.springboot.entity.Discuss;
import com.ambow.springboot.mapper.DiscussMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscussTest {
    @Autowired
    private DiscussMapper discussMapper;

    /**
     * 查询所有的评论和回复
     */
    @Test
    public void testMysql() {
        System.out.println(discussMapper.DiscussList());
    }

    /**
     * 增加一条评论
     */
    @Test
    public void saveDiscuss() {
        Discuss discuss=new Discuss();

        discuss.setInfo("哈哈");
        discuss.setDiscussTime(new Date());
        discussMapper.insertSelective(discuss);

    }
    /**
     * 增加一条回复
     */
    @Test
    public void saveReply() {
        Discuss discuss=new Discuss();

        discuss.setInfo("呵呵");
        discuss.setDiscussId(5);
        discuss.setDiscussTime(new Date());
        discussMapper.insertSelective(discuss);

    }
}
