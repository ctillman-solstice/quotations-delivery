package org.example.quotations_delivery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@ConfigurationProperties(prefix = "forismaticapi")
@Component
public class ForismaticApiProperties {
    private String url;

    public ForismaticApiProperties() {

    }

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public Resource getResource() throws MalformedURLException {
        return new UrlResource(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
