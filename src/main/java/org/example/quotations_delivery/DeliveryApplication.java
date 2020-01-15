package org.example.quotations_delivery;

import org.example.quotations_delivery.service.ChuckNorrisService;
import org.example.quotations_delivery.service.ForismaticService;
import org.example.quotations_delivery.service.QuotationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableConfigurationProperties
public class DeliveryApplication {

    public static void main(String args[]) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

    @Primary
    @Bean
    @DependsOn({"chuckNorrisService", "forismaticService"})
    @RefreshScope
    public QuotationService service(@Value("${selected_option}") String source,
                                    ChuckNorrisService chuckNorrisService,
                                    ForismaticService forismaticService) {
        System.out.println("refreshed again " + source);

        switch (source) {
            case "chucknorris":
                return chuckNorrisService;
            case "forismatic":
            default:
                return forismaticService;
        }
    }

}
