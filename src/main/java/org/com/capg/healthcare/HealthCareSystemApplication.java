package org.com.capg.healthcare;

import java.util.ArrayList;
import java.util.List;

import org.com.capg.healthcare.dao.DiagnosticCenterRepository;
import org.com.capg.healthcare.dao.TestRepository;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class HealthCareSystemApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx =
		SpringApplication.run(HealthCareSystemApplication.class, args);
		
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("")).build();
	   }
	
	


}
