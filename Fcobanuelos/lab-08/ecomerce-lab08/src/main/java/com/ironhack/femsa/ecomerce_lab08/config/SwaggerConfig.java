package com.ironhack.femsa.ecomerce_lab08.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API para Comercio Electrónico")
                        .description("API RESTful para gestión de usuarios, pedidos y soporte al cliente")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Soporte")
                                .email("soporte@ecommerce.com")));
    }
}
