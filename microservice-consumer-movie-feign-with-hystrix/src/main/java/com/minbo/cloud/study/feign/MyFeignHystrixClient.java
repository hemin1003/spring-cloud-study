package com.minbo.cloud.study.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.minbo.cloud.study.feign.MyFeignHystrixClient.HystrixClientFallback;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，还可以使用url参数指定一个URL。
 */
@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
public interface MyFeignHystrixClient {

	// 定义代码调用对方服务的"/hi"接口
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);

	/**
	 * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
	 */
	@Component
	class HystrixClientFallback implements MyFeignHystrixClient {

		@Override
		public String sayHiFromClientOne(String name) {
			String result = "from feign，异常发生，进入fallback方法，接收的参数：name = " + name;
			System.out.println(result);
			return result;
		}

	}
}