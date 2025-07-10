package com.manager.task.systems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.manager.task.model")
@ComponentScan(basePackages = { "com.*" })
@EnableJpaRepositories(basePackages = { "com.manager.task.repository" })
@EnableTransactionManagement
public class BlGestorSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlGestorSystemApplication.class, args);
	}

}
