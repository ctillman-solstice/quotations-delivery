package org.example.quotations_delivery.config;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class HttpsClientConfiguration {
    public HttpsClientConfiguration() {

    }

    @Bean
    public HttpComponentsClientHttpRequestFactory httpsRequestFactory(CloseableHttpClient closeableHttpClient) {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(closeableHttpClient);

        return requestFactory;
    }

    @Bean
    public CloseableHttpClient closeableHttpClient() {
        return HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
    }
}
