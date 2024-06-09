package com.example.test;

import com.example.test.util.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class JavaSpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringTestApplication.class, args);
		Settings Settings = new Settings();
		Settings.load();
	}

}
