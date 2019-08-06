package com.minbo.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@RestController
public class GreetRestController {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/greet")
	public String call() {
		System.out.println("calling trace zipkin-greet");
		return this.restTemplate.getForObject("http://localhost:8988/info", String.class);
	}

	@RequestMapping("/info")
	public String info() {
		System.out.println("calling trace zipkin-greet");
		return "i'm zipkin-greet";
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}