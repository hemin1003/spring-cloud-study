package com.minbo.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Feign是一个声明式的web service客户端，它使得编写web service客户端更为容易。
 * 创建接口，为接口添加注解，即可使用Feign。
 * Feign可以使用Feign注解或者JAX-RS注解，还支持热插拔的编码器和解码器。
 * Spring Cloud为Feign添加了Spring MVC的注解支持，并整合了Ribbon和Eureka来为使用Feign时提供负载均衡。
 * 使用@EnableFeignClients开启Feign
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MovieFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieFeignApplication.class, args);
	}
}
