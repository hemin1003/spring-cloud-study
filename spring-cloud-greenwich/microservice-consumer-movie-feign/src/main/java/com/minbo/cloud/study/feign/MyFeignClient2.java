package com.minbo.cloud.study.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("microservice-consumer-movie-feign-with-hystrix")注解绑定microservice-consumer-movie-feign-with-hystrix服务，还可以使用url参数指定一个URL。
 */
@FeignClient(name = "microservice-consumer-movie-feign-with-hystrix")
public interface MyFeignClient2 {

	// 定义代码调用对方服务的"/city"接口
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	String fromCityFromClientOne(@RequestParam(value = "city") String city);

}