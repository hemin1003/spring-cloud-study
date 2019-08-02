package com.minbo.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minbo.cloud.study.service.RibbonService;

@RestController
public class RibbonController {

	@Autowired
	private RibbonService ribbonService;

	@GetMapping(value = "/hi")
	public String hi(@RequestParam String name) {
		return this.ribbonService.hiService(name);
	}
}
