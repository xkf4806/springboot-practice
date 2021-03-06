package com.springboot.tutorial.demo01.mapper;

import com.github.pagehelper.PageHelper;
import com.springboot.tutorial.demo01.entity.User;
import com.springboot.tutorial.demo01.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria().andNameLike("%张%");
        int i = userMapper.deleteByExample(userExample);
        System.out.println(i);
    }

    @Test
    public void insertSelective() throws Exception {
        User user = new User();
        user.setName("张三");
        user.setAge(28);
        userMapper.insertSelective(user);
    }

    @Test
    public void updateByExampleSelective() throws Exception {
        User user = new User();
        user.setName("李四");
        user.setAge(15);
        UserExample example = new UserExample();
        example.createCriteria().andAgeGreaterThan(30);
        userMapper.updateByExampleSelective(user,example);
    }

    @Test
    public void selectByPage() {
        PageHelper.startPage(2, 5); // 使用pageHelper插件，分页功能如此简单
        UserExample example = new UserExample();
        List<User> users = userMapper.selectByExample(example);
        for (User user : users) {
            System.out.println(user);
        }
    }

}