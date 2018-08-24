package com.springboot.tutorial.customautoconfig;

import com.springboot.autoconfigure.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 使用自定义自动化配置
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@RestController
@RequestMapping(value = "/autoconfigure")
public class HelloAutoConfigConfigurationController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String sayHello() {
        return helloService.sayHello();
    }
}
