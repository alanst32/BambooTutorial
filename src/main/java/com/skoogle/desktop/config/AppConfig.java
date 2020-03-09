package com.skoogle.desktop.config;

import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Configuration
@EnableSwagger2
public class AppConfig extends WebMvcConfigurationSupport {

    @Value("${mongo.uri}")
    private String mongoURI;

    @Value("${mongo.uri.database}")
    private String mongoDatabase;

    // Swagger address: http://localhost:8080/swagger-ui.html
    @Bean
    public Docket fixedFileFormatConverter() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.skoogle.desktop.controller"))
            .paths(regex("/skoogle.*"))
            .build()
            .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
            .title("Skoogle Api Docs")
            .description("\"Skoogle Rest API Docs\"")
            .version("1.0.0")
            .license("Apache License Version 2.0")
            .contact(new Contact("Skoogle", "http://skoogleapp.com", "skoogleapp@gmail.com"))
            .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        // MongoClientURI mongoClientURI = new MongoClientURI(mongoURI);
        // MongoClient mongoClient = new MongoClient(mongoClientURI);
        return new SimpleMongoClientDbFactory(mongoURI);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(this.mongoDbFactory());
        return mongoTemplate;
    }

    @Bean
    public MongoDatabase mongoDatabase() throws Exception {
        return this.mongoTemplate().getDb();
    }
}
