package com.springboot.tutorial.listener.unordered;

import com.springboot.tutorial.listener.UserEntity;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Description: 定义用户注册的事件
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@Getter
public class UserRegisterEvent extends ApplicationEvent {

    private UserEntity user;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserRegisterEvent(Object source, UserEntity user) {
        super(source);
        this.user = user;
    }
}
