package main.java.com.project.config;

//
//import com.azure.core.credential.AzureKeyCredential;
//import com.azure.cosmos.CosmosClientBuilder;
//import com.azure.cosmos.DirectConnectionConfig;
//import com.azure.cosmos.GatewayConnectionConfig;
//import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
//import com.azure.spring.data.cosmos.config.CosmosConfig;
//import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
//import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;
//import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//@EnableCosmosRepositories(basePackages = "com.project.model")
public class AppCosmosConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppCosmosConfig.class);
//
//    @Value("${azure.cosmos.uri}")
//    private String uri;
//    @Value("${azure.cosmos.key}")
//    private String key;
//    @Value("${azure.cosmos.secondaryKey}")
//    private String secondaryKey;
//    @Value("${azure.cosmos.database}")
//    private String database;
//    @Value("${azure.cosmos.queryMetricsEnabled}")
//    private boolean queryMetricsEnabled;
//
////    private AzureKeyCredential azureKeyCredential;
////
////    @Bean
////    public CosmosClientBuilder getCosmosClientBuilder() {
////        this.azureKeyCredential = new AzureKeyCredential(key);
////        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
////        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
////        return new CosmosClientBuilder()
////                .endpoint(uri)
////                .credential(azureKeyCredential)
////                .directMode(directConnectionConfig, gatewayConnectionConfig);
////    }
////
////    @Bean
////    public CosmosConfig cosmosConfig() {
////        return CosmosConfig.builder()
////                .enableQueryMetrics(queryMetricsEnabled)
////                .responseDiagnosticsProcessor(new ResponseDiagnosticsImplementation())
////                .build();
////    }
//
//    @Override
//    protected String getDatabaseName() {
//        return database;
//    }
//
//    private static class ResponseDiagnosticsImplementation implements ResponseDiagnosticsProcessor {
//        @Override
//        public void processResponseDiagnostics(ResponseDiagnostics responseDiagnostics) {
//            LOGGER.info("Response Diagnostics {}", responseDiagnostics);
//        }
//    }
}
