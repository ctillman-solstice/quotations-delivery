package org.example.quotations_delivery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@ConfigurationProperties(prefix = "forismaticapi")
@Component
public class ForismaticApiProperties {
    private String url;

    public ForismaticApiProperties() {

    }

    public HttpEntity getHttpEntity() {
        return new HttpEntity<String>("parameters", getHttpHeaders());
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:72.0) Gecko/20100101 Firefox/72.0");

        return headers;
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
