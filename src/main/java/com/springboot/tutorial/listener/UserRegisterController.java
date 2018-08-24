package com.springboot.tutorial.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 用户注册控制器
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserRegisterController {

    @Autowired
    private UserService userRegisterService;

    @GetMapping(value = "/register")
    public UserEntity register(UserEntity user) {
        userRegisterService.register(user);
        log.info("用户注册成功，用户信息：{}", user);
        return user;
    }
}
