package org.example.quotations_delivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@ConfigurationProperties(prefix = "chucknorrisapi")
@Component
public class ChuckNorrisApiProperties {
    private String url;
    private HttpComponentsClientHttpRequestFactory requestFactory;

    @Autowired
    public ChuckNorrisApiProperties(HttpComponentsClientHttpRequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    public RestTemplate getRestTemplate() {
        return new RestTemplate(requestFactory);
    }

    public Resource getResource() throws MalformedURLException {
        return new UrlResource(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
