package com.springboot.tutorial.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Description:
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/23
 */
@RequestMapping(value = "/valid")
@RestController
public class ValidController {

    /**
     * 用来格式化错误消息
     */
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/index")
    public String index(@Valid DemoEntity demoEntity, BindingResult result) {
        if(result.hasErrors()) {
            StringBuffer msg = new StringBuffer();
            // 获取错误字段集合
            List<FieldError> fieldErrors = result.getFieldErrors();
            // 获取本地locale
            Locale locale = LocaleContextHolder.getLocale();
            // 遍历错误字段获取错误消息
            fieldErrors.forEach(e -> {
                // 获取错误消息
                String message = messageSource.getMessage(e, locale);
                // 添加到错误消息集合内
                msg.append(e.getField()).append("：").append(message).append(" , ");
            });
            return msg.toString();
        }
        return "验证通过，名称：" + demoEntity.getName() + "，年龄：" + demoEntity.getAge() + "，邮箱：" + demoEntity.getEmail();
    }
}
