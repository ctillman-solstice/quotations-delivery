package org.example.quotations_delivery.service;

import org.example.quotations_delivery.config.ForismaticApiProperties;
import org.example.quotations_delivery.quote.DefaultQuotation;
import org.example.quotations_delivery.quote.Forismatic;
import org.example.quotations_delivery.quote.GenericQuotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@Service
public class ForismaticService implements QuotationService {
    private ForismaticApiProperties apiProperties;

    @Autowired
    public ForismaticService(ForismaticApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    public Forismatic forismaticQuote() throws IOException {
        RestTemplate restTemplate = apiProperties.getRestTemplate();
        URI uri = apiProperties.getResource().getURI();

        return restTemplate.getForObject(uri, Forismatic.class);
    }

    @Override
    public GenericQuotation quotation() {
        try {
            return forismaticQuote();
        } catch (Exception ex) {
            return new DefaultQuotation();
        }
    }
}
