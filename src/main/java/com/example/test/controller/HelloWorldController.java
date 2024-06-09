package com.example.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/hello")
	public String helloworld() {
		logger.info("[HelloWorldController.java:15] Response for /hello is successful.");
		return "Hello World!";
	}

}