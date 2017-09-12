package com.springboot.demo01.service;

import com.springboot.demo01.common.PageInfo;

import java.util.Map;

public interface UserService {
    PageInfo findUserByPage(Map param) throws Exception;
}
