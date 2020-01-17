package org.example.quotations_delivery.error;

public class RestException extends RuntimeException {
    public RestException(String message) {
        super(message);
    }
}
