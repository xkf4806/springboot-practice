package com.springboot.tutorial.demo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * @author xinj.xue
 * @description：event listener advice
 * @date 2017-08-27 14:46
 **/
@ControllerAdvice
public class ResourceUrlProviderController {
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @ModelAttribute("urls")
    public ResourceUrlProvider urls() {
        return this.resourceUrlProvider;
    }
}
