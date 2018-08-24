package com.springboot.tutorial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 * @author xj.x
 * @date 2018-08-23 20:40
 */
@SpringBootApplication
@MapperScan(basePackages = "com.springboot.tutorial.demo01.mapper")
public class Demo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}
}
