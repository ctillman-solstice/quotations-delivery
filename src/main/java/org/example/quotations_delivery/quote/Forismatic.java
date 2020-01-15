package org.example.quotations_delivery.quote;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forismatic implements GenericQuotation, Serializable {
    private String quoteText;
    private String quoteAuthor;
    private String quoteLink;

    public Forismatic() {

    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteLink() {
        return quoteLink;
    }

    public void setQuoteLink(String quoteLink) {
        this.quoteLink = quoteLink;
    }

    @Override
    public String getQuotation() {
        return String.format("%s\n\n-%s\n", quoteText, quoteAuthor);
    }

    @Override
    public String source() {
        return getQuoteLink();
    }
}
