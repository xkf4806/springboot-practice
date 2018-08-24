package com.springboot.tutorial.listener.ordered;

import com.springboot.tutorial.listener.UserEntity;
import com.springboot.tutorial.listener.UserService;
import com.springboot.tutorial.listener.unordered.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Description: 用户注册成功后，发送邮件通知事件监听器
 * 【关注： 用户数据持久化异常对发送邮件的影响】
 *
 * 使用spring内置的异步线程池完成异步任务执行
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@Component
@Slf4j
public class UserRegisterEmailListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType.equals(UserRegisterEvent.class);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType.equals(UserService.class);
    }

    @Override
    @Async
    public void onApplicationEvent(ApplicationEvent event) {
        try {
            Thread.sleep(3 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UserRegisterEvent userEvent = (UserRegisterEvent) event;
        UserEntity user = userEvent.getUser();
        log.info("注册成功发送邮件，user={}", user);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
