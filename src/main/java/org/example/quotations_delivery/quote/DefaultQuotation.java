package org.example.quotations_delivery.quote;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("default")
@Component
public class DefaultQuotation implements GenericQuotation {
    private String quotation;

    @Override
    public String getQuotation() {
        return "If at first you don't succeed, try; try again.";
    }

    public void setQuotation(String q) {
        quotation = q;
    }

    @Override
    public String source() {
        return "Anonymous";
    }
}
