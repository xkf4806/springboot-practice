package com.springboot.tutorial.listener.ordered;

import com.springboot.tutorial.listener.UserEntity;
import com.springboot.tutorial.listener.UserService;
import com.springboot.tutorial.listener.unordered.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Description: 用户注册数据持久化监听器
 * 【观察抛出异常后对后续监听者的影响】
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@Component
@Slf4j
public class UserRegisterPersistenceListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType.equals(UserRegisterEvent.class);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType.equals(UserService.class);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        UserRegisterEvent userEvent = (UserRegisterEvent) event;
        UserEntity user = userEvent.getUser();
        log.info("用户数据持久化成功，user={}", user);
//        throw new RuntimeException("用户注册失败");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
