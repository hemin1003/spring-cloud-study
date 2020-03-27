package com.minbo.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minbo.cloud.study.feign.MyFeignHystrixClient;

@RestController
public class FeignHystrixController {
	
	@Autowired
	private MyFeignHystrixClient feignClient;

	@GetMapping(value = "/hi")
	public String sayHi(@RequestParam String name) {
		String result = this.feignClient.sayHiFromClientOne(name);
		return result;
	}
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/city")
	public String home(@RequestParam(value = "city", defaultValue = "guangzhou") String city) {
		String result = "hi " + city + " , i am from port:" + port;
		System.out.println(result);
		return result;
	}
}