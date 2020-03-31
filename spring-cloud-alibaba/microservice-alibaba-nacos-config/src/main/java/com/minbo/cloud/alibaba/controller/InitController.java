package com.minbo.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minbo.cloud.alibaba.util.JsonResult;
import com.minbo.cloud.alibaba.util.ResultCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Minbo
 */
@RestController
@Slf4j
@Api(tags = { "init" })
@RefreshScope
public class InitController {

	@Value("${config.appKey}")
	private String appKey;

	@ApiOperation(value = "欢迎入口", httpMethod = "GET")
	@GetMapping("/hello")
	public String hello() {
		log.info("microservice-alibaba-nacos-config");
		return "Hello, greetings from microservice-alibaba-nacos-config";
	}

	@ApiOperation(value = "获得AppKey值", httpMethod = "GET")
	@GetMapping("/getAppKey")
	public JsonResult getAppKey() {
		return new JsonResult(ResultCode.SUCCESS, this.appKey);
	}
}