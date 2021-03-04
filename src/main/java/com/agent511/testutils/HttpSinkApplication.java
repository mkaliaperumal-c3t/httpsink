package com.agent511.testutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpSinkApplication.class, args);
		System.out.println("Sink is Ready");
	}

}
