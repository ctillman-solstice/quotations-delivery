package org.example.quotations_delivery.service;

import org.example.quotations_delivery.config.ForismaticApiProperties;
import org.example.quotations_delivery.error.RestException;
import org.example.quotations_delivery.quote.Forismatic;
import org.example.quotations_delivery.quote.GenericQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

@Service
public class ForismaticService implements QuotationService {
    private ForismaticApiProperties apiProperties;

    @Autowired
    public ForismaticService(ForismaticApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    public ResponseEntity<Forismatic> forismaticQuote() throws IOException {
        RestTemplate restTemplate = apiProperties.getRestTemplate();
        URL url = apiProperties.getResource().getURL();

        return restTemplate.exchange(url.toString(),
                HttpMethod.GET,
                apiProperties.getHttpEntity(),
                Forismatic.class);
    }

    @Override
    public GenericQuotation quotation() {
        try {
            return forismaticQuote().getBody();
        } catch (IOException ex) {
            throw new RestException(ex.getMessage());
        }
    }
}
