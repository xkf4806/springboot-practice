package com.springboot.tutorial.listener;

import com.springboot.tutorial.listener.unordered.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Description: 业务方法通过注入的ApplicationContext完成用户注册事件的发布
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@Service(value = "userRegisterService")
@Slf4j
public class UserService {

    @Autowired
    private ApplicationContext context;

    public void register(UserEntity user) {
        context.publishEvent(new UserRegisterEvent(this, user));
        log.info("发布用户注册事件成功！");
    }
}
