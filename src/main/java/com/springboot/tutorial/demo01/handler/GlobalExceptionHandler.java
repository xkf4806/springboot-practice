package com.springboot.tutorial.demo01.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xinj.xue
 * @description：全局异常处理
 * @date 2017-08-26 0:40
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handler() {
        return "出异常了";
    }
}
