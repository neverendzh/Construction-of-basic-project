package com.neverend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieEurakeProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieEurakeProviderApplication.class, args);
	}
}
