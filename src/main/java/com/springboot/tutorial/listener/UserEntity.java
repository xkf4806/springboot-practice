package com.springboot.tutorial.listener;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 用户实体数据封装
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@Data
public class UserEntity implements Serializable {
    private String name;
    private Integer age;
}
