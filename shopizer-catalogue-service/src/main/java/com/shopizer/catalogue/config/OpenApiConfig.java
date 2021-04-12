package com.shopizer.catalogue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Shopizer Catalog API")
				.description("All about catalogue - category - products management"));
	}
	
	
	/*
	 * @Bean public OpenAPI customOpenAPI(BuildProperties buildProperties) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return new OpenAPI() .components(new
	 * Components().addSecuritySchemes("basicScheme", new
	 * SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))) .info( new
	 * Info() .title("Catalog API") .version(buildProperties.getVersion())
	 * .description( "Catalog , category and products management")
	 * .termsOfService("http://swagger.io/terms/") .license(new
	 * License().name("Apache 2.0").url("https://www.shopizer.com"))); }
	 */

}
