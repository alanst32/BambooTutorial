package main.java.com.project.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoClientSettingsFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
//@Import({AppCosmosConfig.class})
@ComponentScan(
    basePackages = {"com.project"}
)
public class AppConfig implements WebMvcConfigurer {

    @Value("${mongo.uri}")
    private String uri;
    @Value("${mongo.database}")
    private String database;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://cosmos-alan-mern:DA3yOkc01eimjWVQ4u9LQUNaZ0UXAFjjQkf5GBA6Sl2220OlLMV5VJJSmfEhB0WWqIheSaXdFicS9JFG9C2L6g%3D%3D@cosmos-alan-mern.mongo.cosmos.azure.com:10255/mern-cosmos?ssl=true&appName=@cosmos-alan-mern@");
        MongoClientSettings mongoClientSettings = MongoClientSettings
            .builder()
            .applyConnectionString(connectionString)
            .applyToSslSettings(builder -> builder.enabled(true))
            .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoDatabase mongoDatabase() {
        return this.mongoClient().getDatabase(database);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(this.mongoClient(), database);
    }

    @Bean
    public Docket fixedFileFormatConverter() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.project.controller"))
            .paths(regex("/project.*"))
            .build()
            .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("General Project")
                .description("\"Bamboo Tutorial Project\"")
                .version("1.0.0")
                .license("Apache license Version 2.0")
                .contact(new Contact("Alan Terriaga", "", ""))
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
