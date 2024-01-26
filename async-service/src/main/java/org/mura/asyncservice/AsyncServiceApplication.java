package org.mura.asyncservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ConfigurationPropertiesScan
@EnableAsync
@SpringBootApplication
public class AsyncServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(AsyncServiceApplication.class, args);
	}


}
