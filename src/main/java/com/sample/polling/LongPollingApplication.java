package com.sample.polling;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LongPollingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LongPollingApplication.class, args);
	}
}
