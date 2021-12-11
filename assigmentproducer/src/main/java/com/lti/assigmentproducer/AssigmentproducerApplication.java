package com.lti.assigmentproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
public class AssigmentproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssigmentproducerApplication.class, args);
	}

}
