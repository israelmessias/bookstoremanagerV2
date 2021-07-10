package com.messias.bookstoremanagerv2.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //caminho principal do projeto
    private static final String BASE_PACKAGE = "com.messias.bookstoremanagerv2";
    //titulo do projeto
    private static final String API_TITLE = "Bookstore Manager V2";
    //descrição do projeto
    private static final String API_DESCRIPTION = "Bookstore Manager API Professional";
    //versão
    private static final String API_VERSION = "1.0.0";
    //nome
    private static final String CONTACT_NAME = "Israel Messias";
    //github
    private static final String CONTACT_URL = "htpps://github.com/israelmessias";
    //meu email
    private static final String CONTACT_EMAIL = "israelmessias2016@outlook.com";

    /*Depois de definir o Docket bean , seu select () método retorna uma instância de ApiSelectorBuilder ,
     que fornece uma maneira de controlar os endpoints expostos pelo Swagger.
    Podemos configurar predicados para selecionar RequestHandler s com a ajuda de RequestHandlerSelectors e PathSelectors.
     Usar any () para ambos tornará a documentação de toda a nossa API disponível por meio do Swagger. */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).
                paths(PathSelectors.any()).
                build().apiInfo(buildApiInfo());
    }
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder().
                title(API_TITLE).
                description(API_DESCRIPTION).
                version(API_VERSION)
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"").
                contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL)).
                build();
    }
}
