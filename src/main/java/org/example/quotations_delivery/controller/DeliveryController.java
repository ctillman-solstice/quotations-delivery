package org.example.quotations_delivery.controller;

import org.example.quotations_delivery.quote.GenericQuotation;
import org.example.quotations_delivery.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class DeliveryController {
    private QuotationService service;

    @Autowired
    public DeliveryController(QuotationService quotationService) {
        this.service = quotationService;
    }

    @GetMapping("")
    public @ResponseBody
    String quotation() {
        GenericQuotation quotation = service.quotation();
        return quotation.getQuotation()
                + "\n(" + quotation.source()
                + ")\n";
    }

}
