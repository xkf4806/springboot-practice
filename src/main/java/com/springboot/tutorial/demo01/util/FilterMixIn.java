package com.springboot.tutorial.demo01.util;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author xinj.xue
 * @description：
 * @date 2017-09-12 22:55
 **/
@JsonFilter(value="baseFilterId")
public interface FilterMixIn {

}

