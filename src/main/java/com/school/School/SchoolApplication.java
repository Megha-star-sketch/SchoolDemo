package com.school.School;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()				
				//.paths(PathSelectors.ant("/Staff/*"))
				.apis(RequestHandlerSelectors.basePackage("com.school.School"))
				.build()
				.apiInfo(apiInfo());
	}
	
	public static final ApiInfo apiInfo()
	 {
		return new ApiInfoBuilder().title("SpringBoot Swagger Example API").description("SpringBoot Swagger Example API for YouTube").version("2.9.2").build();
		}

}
