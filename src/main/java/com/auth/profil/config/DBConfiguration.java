package com.auth.profil.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")

public class DBConfiguration {
	
	public String driverClassName ;
	
	@Profile("test")
	@Bean
	public String testDataBaseConnection() {
		System.out.println("connection to h2");
		System.out.println(driverClassName);
		return "DB Connection for H2";
	}
	
	@Profile("dev")
	@Bean
	public String devDataBaseConnection() {
		System.out.println("connection to mysql");
		System.out.println(driverClassName);
		return "DB Connection for Mysql";
	}

}
