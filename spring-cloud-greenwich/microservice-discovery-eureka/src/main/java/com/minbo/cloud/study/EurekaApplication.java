package com.minbo.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	//测试提交代码到git
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}