package com.neverend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakeServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurakeServer2Application.class, args);
	}
}
