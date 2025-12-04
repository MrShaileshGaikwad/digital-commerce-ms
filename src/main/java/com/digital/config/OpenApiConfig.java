package com.digital.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Digital Commerce Employee Service API",
                version = "1.0",
                description = "APIs for managing employees in a Digital Commerce (Arrow ECS style) platform"
        )
)
public class OpenApiConfig {
}

//Run the app and open:
//
//http://localhost:8080/swagger-ui.html
//or
//
//http://localhost:8080/swagger-ui/index.html