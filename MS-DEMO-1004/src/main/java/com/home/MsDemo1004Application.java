package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsDemo1004Application {
// This DEMO-1004 MS Service main method.
	public static void main(String[] args) {
		
		SpringApplication.run(MsDemo1004Application.class, args);
	}

}
