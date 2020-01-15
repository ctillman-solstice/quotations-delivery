package org.example.quotations_delivery.quote;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ChuckNorris implements GenericQuotation {
    private List<String> categories;
    @JsonAlias("created_at")
    String createdAt;
    @JsonAlias("icon_url")
    String iconUrl;
    String id;
    @JsonAlias("updated_at")
    String updatedAt;
    String url;
    @JsonAlias("value")
    String quotation;

    @Override
    public String getQuotation() {
        return quotation + "\n";
    }

    @Override
    public String source() {
        return url;
    }
}