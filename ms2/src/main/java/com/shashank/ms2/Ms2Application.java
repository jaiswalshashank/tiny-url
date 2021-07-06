package com.shashank.ms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.shashank.ms2")
@EnableDiscoveryClient
@SpringBootApplication
public class Ms2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms2Application.class, args);
	}

}
