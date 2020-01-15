package org.example.quotations_delivery.service;

import org.example.quotations_delivery.config.ChuckNorrisApiProperties;
import org.example.quotations_delivery.quote.ChuckNorris;
import org.example.quotations_delivery.quote.DefaultQuotation;
import org.example.quotations_delivery.quote.GenericQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@Service
public class ChuckNorrisService implements QuotationService {
    private ChuckNorrisApiProperties apiProperties;

    @Autowired
    public ChuckNorrisService(ChuckNorrisApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    public ChuckNorris chuckNorrisQuotation() throws IOException {
        RestTemplate restTemplate = apiProperties.getRestTemplate();
        URI uri = apiProperties.getResource().getURI();

        return restTemplate.getForObject(uri, ChuckNorris.class);
    }

    @Override
    public GenericQuotation quotation() {
        try {
            return chuckNorrisQuotation();
        } catch (Exception ex) {
            return new DefaultQuotation();
        }
    }
}
