package com.springboot.tutorial.listener.unordered;

import com.springboot.tutorial.listener.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Description: 用户注册事件监听者
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
//@Component
@Slf4j
public class UserRegisterListener {
//    @EventListener
    public void userRegister(UserRegisterEvent event) {
        UserEntity user = event.getUser();
        log.info("保存用户数据： user={}", user);
    }
}
