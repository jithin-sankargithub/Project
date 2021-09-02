package com.eshopping.cartservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CartserviceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CartserviceApplication.class, args);
	}
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eshopping"))
				.build().apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return  new ApiInfo(
				"Cart Service",
				"Cart Management for EShoppingZone",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Jithin Sankar M", "http://EshoppingZone.com","Jithin@EShoppingZone.com"),
				"Api License",
				"http://EShoppingZone.com",
				Collections.emptyList());
	}


}
