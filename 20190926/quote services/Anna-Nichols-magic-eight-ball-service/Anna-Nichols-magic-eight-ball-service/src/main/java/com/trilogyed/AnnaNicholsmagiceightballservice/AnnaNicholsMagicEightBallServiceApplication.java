package com.trilogyed.AnnaNicholsmagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AnnaNicholsMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnaNicholsMagicEightBallServiceApplication.class, args);
	}

}
