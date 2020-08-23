package com.example.configuration;
/**
 * @author can
 * @date 8/18/20
 */

import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class AppConfig {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public BlobServiceClient blobServiceClient(){
        ManagedIdentityCredential managedIdentityCredential =
                new ManagedIdentityCredentialBuilder().maxRetry(3).retryTimeout(duration -> Duration.ofMinutes(1)).build();
        logger.info("ManagedIdentityCredential Client Id: {}", managedIdentityCredential);

        return new BlobServiceClientBuilder().endpoint("https://umr7227.blob.core.windows.net").credential(managedIdentityCredential)
                .buildClient();

    }
}
