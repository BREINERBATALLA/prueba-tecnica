package com.nexsys.prueba.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Breiner Batalla",
                        email = "breiner.batalla@correounivalle.edu.co"
                ),
                description = "OpenApi documentation for nexsys tecnhical interview",
                title = "OpenApi specification - Consuming external services",
                version = "1.0",
                termsOfService = "Tearms of service"

        ),
        servers = {
                @Server(
                        description = "LOCAL ENVIRONMENT",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {}
