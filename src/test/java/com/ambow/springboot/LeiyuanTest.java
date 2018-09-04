package com.ambow.springboot;

import com.ambow.springboot.entity.Roles;
import com.ambow.springboot.service.RolesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeiyuanTest {
    @Autowired
    private RolesService rolesService;

    @Test
    public void testQueryAll() {
        System.out.println(rolesService.queryAll());
    }

    @Test
    public void testSave() {
        Roles roles = new Roles();
        roles.setMeanName("添加");
        roles.setMeanUrl("/index/save");
        roles.setName("左侧添加");
        rolesService.save(roles);
    }

    @Test
    public void getMean() {
        System.out.println(rolesService.getMeanByRoles("左侧添加"));
    }
}
