package com.test.bideafac.documentacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DocumentacionApi {
    @Bean
    public Docket api() {
        final Docket build = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(queryApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.bideafac"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("BookRequest", "Se permite Reservar una casa")
                );
        return build;
    }

    public ApiInfo queryApiInfo() {
        return new ApiInfoBuilder()
                .title("TEST")
                .description("TEST BIDEA FACTORY")
                .version("1.0.0")
                .license("Version 1.0")
                .licenseUrl("https://github.com/BrayanBg")
                .contact(new Contact("Bidea Factory", "https://github.com/BrayanBg", "info@example.com"))
                .build();
    }

}
