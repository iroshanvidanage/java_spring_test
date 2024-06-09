package com.example.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public String Root(){
        logger.info("[RootController.java:15] Response for / is successful.");
        return "Welcome to Iroshan's test Java Springboot application.";
    }
}
