package com.stackroute.springeurekaclientmuzixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringEurekaClientMuzixServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientMuzixServiceApplication.class, args);
	}

}
