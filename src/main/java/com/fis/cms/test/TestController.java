package com.fis.cms.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/about")
	public String sayHello() {
		return "hello";
	}
}
