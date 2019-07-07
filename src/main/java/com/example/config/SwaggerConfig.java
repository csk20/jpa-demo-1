package com.example.config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	
	@Bean
	public Docket productApi() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.resource")).build();
			//	.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// .title(title)
				//
				.description(readSwaggerDocument())
				// .license(LICENSE_TEXT)
				 .version("1.0")
				.build();
	}

	String readSwaggerDocument() {
		StringBuilder builder = new StringBuilder();
		try (InputStream is = this.getClass().getResourceAsStream("/static/swagger.html")) {

			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			int c; 
			  while ((c = br.read()) != -1) 
				  builder.append((char)c) ; 
			  
			
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return builder.toString();
	}
}
