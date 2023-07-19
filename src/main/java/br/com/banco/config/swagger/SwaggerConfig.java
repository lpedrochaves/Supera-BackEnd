package br.com.banco.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api(){
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("br.com.banco"))
	.paths(PathSelectors.any())
	.build()
	.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo(){
		ApiInfo apiInfo = new ApiInfoBuilder()
		.title("API Supera Processo Seletivo")
		.description("Essa é uma API desenvolvida para o processo seletivo da Supera")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/license/LICENSE-2.0")
		.version("1.0.0")
		.build();
		return apiInfo;
		}
}
