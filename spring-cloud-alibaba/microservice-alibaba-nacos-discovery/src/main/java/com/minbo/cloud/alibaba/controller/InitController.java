package com.minbo.cloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Minbo
 */
@RestController
@Slf4j
@Api(tags = { "init" })
public class InitController {

	/**
	 * http://localhost:9090/hello
	 * 
	 * @return
	 */
	@ApiOperation(value = "欢迎入口", httpMethod = "GET")
	@GetMapping("/hello")
	public String hello() {
		log.info("microservice-alibaba-nacos-discovery");
		return "Hello, greetings from microservice-alibaba-nacos-discovery";
	}

}