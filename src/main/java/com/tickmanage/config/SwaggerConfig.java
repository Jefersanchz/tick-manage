package com.tickmanage.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://tick-manage-app-808532545955.us-central1.run.app"))
                .info(new Info()
                        .title("Ticket Management API")
                        .version("1.0")
                        .description("API for managing tickets with pagination and user filtering"));
    }
}
