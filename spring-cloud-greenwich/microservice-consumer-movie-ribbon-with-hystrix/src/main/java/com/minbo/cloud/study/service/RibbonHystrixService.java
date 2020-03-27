package com.minbo.cloud.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonHystrixService {
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
	 * 
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public String hiService(String name) {
		String result = restTemplate.getForObject("http://microservice-provider-user/hi?name=" + name, String.class);
		System.out.println(result);
		return result;
	}

	/**
	 * hystrix fallback方法
	 * 
	 * @return 默认返回数据
	 */
	public String fallback(String name) {
		String result = "异常发生，进入fallback方法，接收的参数：name = " + name;
		System.out.println(result);
		return result;
	}
}
