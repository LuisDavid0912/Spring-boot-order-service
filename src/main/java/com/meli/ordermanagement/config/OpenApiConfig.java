package com.meli.ordermanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Management Service API")
                        .version("1.0")
                        .description("This is a RESTful API for managing e-commerce orders, developed with Spring Boot.")
                        .contact(new Contact()
                                .name("Luis David Martinez Gutierrez")
                                .email("luisdavidmtz3@gmail.com")
                                .url("https://github.com/LuisDavid0912/Spring-boot-order-service"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}