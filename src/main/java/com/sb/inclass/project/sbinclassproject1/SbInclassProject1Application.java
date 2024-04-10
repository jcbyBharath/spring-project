package com.sb.inclass.project.sbinclassproject1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@OpenAPIDefinition(info= @Info(title="Company API", version = "1.0"))
@EnableDiscoveryClient
public class SbInclassProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SbInclassProject1Application.class, args);
	}
/*
	@Bean
	public EurekaInstanceConfig eurekaInstanceConfig() {
		CloudInstanceConfig cloudInstanceConfig = new CloudInstanceConfig();
		cloudInstanceConfig.setHostname("custom-hostname");
		cloudInstanceConfig.setIpAddress("custom-ip-address");
		return cloudInstanceConfig;
	}*/

}
