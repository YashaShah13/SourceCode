package com.example.RESTAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = { "com.controllers", "com.services" })
@EnableJpaRepositories(basePackages = { "com.repository" })
@EntityScan(basePackages = { "com.models" })
public class RestapiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(RestapiApplication.class);
	}

}
