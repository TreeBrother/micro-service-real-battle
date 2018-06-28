package com.pdh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceRealBattleEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRealBattleEurekaApplication.class, args);
	}
}
