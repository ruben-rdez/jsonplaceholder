package com.jsonplaceholder.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
                            title = "JSONPlaceholder API", 
                            version = "v1", 
                            description = "API for managing posts from JSONPlaceholder"))
public class SwaggerConfig {
}
