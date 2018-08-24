package com.springboot.tutorial.demo01.service.impl;

import com.github.pagehelper.PageHelper;
import com.springboot.tutorial.demo01.common.PageInfo;
import com.springboot.tutorial.demo01.entity.User;
import com.springboot.tutorial.demo01.mapper.UserMapper;
import com.springboot.tutorial.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xinj.xue
 * @description：
 * @date 2017-09-12 22:33
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findUserByPage(Map param) throws Exception {
        PageInfo pageInfo = new PageInfo();
        Map map = (Map) param.get("pageInfo");
        PageHelper.startPage(Integer.parseInt(map.get("pageNum").toString()), Integer.parseInt(map.get("pageSize").toString()));
        List<User> users = userMapper.findUserByCondition(param);
        Integer count = userMapper.countUserByCondition(param);
        pageInfo.setTotalCount(count);
        pageInfo.setData(users);
        return pageInfo;
    }
}
