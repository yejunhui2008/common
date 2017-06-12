package com.yejh.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * pom如果有数据驱动配置会导致无法启动
 * @author yejh
 * 2017年3月17日
 */
@ComponentScan("com.yejh.spring.springboot")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
