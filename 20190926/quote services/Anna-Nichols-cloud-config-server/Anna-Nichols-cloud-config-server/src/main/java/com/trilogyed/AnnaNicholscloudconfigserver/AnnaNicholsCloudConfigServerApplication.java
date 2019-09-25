package com.trilogyed.AnnaNicholscloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AnnaNicholsCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnaNicholsCloudConfigServerApplication.class, args);
	}

}
