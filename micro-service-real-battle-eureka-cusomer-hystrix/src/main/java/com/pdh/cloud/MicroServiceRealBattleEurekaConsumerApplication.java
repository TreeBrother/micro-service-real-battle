package com.pdh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker //断路器
@EnableDiscoveryClient
public class MicroServiceRealBattleEurekaConsumerApplication {
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRealBattleEurekaConsumerApplication.class, args);
	}
}
