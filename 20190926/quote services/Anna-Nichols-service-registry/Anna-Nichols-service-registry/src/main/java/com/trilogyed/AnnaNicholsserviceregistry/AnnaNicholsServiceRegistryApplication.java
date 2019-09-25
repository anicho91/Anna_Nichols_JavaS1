package com.trilogyed.AnnaNicholsserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AnnaNicholsServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnaNicholsServiceRegistryApplication.class, args);
	}

}
