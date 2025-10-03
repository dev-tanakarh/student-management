package com.dev_tanakarh.Students.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi studentsApi() {
        return GroupedOpenApi.builder()
                .group("students-api")
                .pathsToMatch("/students/**", "/courses/**", "/enrollments/**", "/exam-results/**")
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info()
                        .title("Student Management API")
                        .description("API for managing students, courses, enrollments, and exam results")
                        .version("1.0.0")
                        .contact(new Contact().name("Tanaka Rodney").email("your-email@example.com"))
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/yourusername/students-api"));
    }
}
