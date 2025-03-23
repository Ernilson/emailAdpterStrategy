package br.com.emailAdapter.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Minha API",
        version = "1.0"
))
@Configuration
public class SwaggerConig {
    @Bean
        public OpenAPI emailServiceOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Email Service API")
                            .description("API para envio de e-mails")
                            .version("1.0")
                            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                    .externalDocs(new ExternalDocumentation()
                            .description("Documentação completa")
                            .url("https://meusite.com/docs"));
        }
    }
