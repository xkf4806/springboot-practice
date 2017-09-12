package com.springboot.demo01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xinj.xue
 * @description：页面跳转controller
 * @date 2017-08-26 14:56
 **/
@Controller
public class IndexController {



    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping(value = "/toHello")
    public String index(ModelMap map) {
        logger.debug("你好==================》");
        map.addAttribute("name","Michael Jordan!!");
        return "hello";
    }

    public String getUserByPage() {

        return "";
    }
}
