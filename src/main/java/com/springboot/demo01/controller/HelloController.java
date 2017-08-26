package com.springboot.demo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinj.xue
 * @description：HelloController
 * @date 2017-08-26 0:14
 **/
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String say() {
        int num = 100 / 0;
        return "Hello Springboot!";
    }

    @GetMapping(value = "/json")
    public String getJson() {
        String json = "{\"name\":\"wangwu\",\"age\":30}";
        return json;
    }

}
